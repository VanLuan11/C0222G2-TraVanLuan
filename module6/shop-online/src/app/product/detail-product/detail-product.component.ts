import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Title} from '@angular/platform-browser';
import {ToastrService} from 'ngx-toastr';
import {Customer} from "../../model/customer";
import {OrderService} from "../../service/order.service";
import {Order} from "../../model/order";
import {CommonService} from "../../login/service/common.service";
import {CustomerService} from "../../service/customer.service";
import {Subscription} from "rxjs";
import {CookieService} from "../../login/service/cookie.service";

@Component({
  selector: 'app-detail-product',
  templateUrl: './detail-product.component.html',
  styleUrls: ['./detail-product.component.css']
})
export class DetailProductComponent implements OnInit {

  role: string = '';
  username: string = '';
  token: string = '';
  messageReceived: any;
  private subscriptionName: Subscription;
  product: Product;
  // product: Product = {};
  number: number;
  id: number;
  customer: Customer;
  infoStatus: boolean = false;
  productOrders: Order[];

  constructor(private cookieService: CookieService,
              private productService: ProductService,
              private toast: ToastrService,
              private title: Title,
              private active: ActivatedRoute,
              private router: Router,
              private orderService: OrderService,
              private commonService: CommonService,
              private customerService: CustomerService) {
    this.title.setTitle("Chi Tiết Sản Phẩm")
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
    // subscribe to sender component messages
    this.subscriptionName = this.commonService.getUpdate().subscribe(message => {
      this.messageReceived = message;
      this.role = this.readCookieService('role');
      this.username = this.readCookieService('username');
      this.token = this.readCookieService('jwToken');
      this.getCustomerByUsername(this.username)
    });
  }

  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }

  ngOnInit(): void {
    this.getById()
    this.getCustomerByUsername(this.username)
  }


  getById() {
    this.active.paramMap.subscribe((paraMap: ParamMap) => {
      const id = paraMap.get('id')
      this.productService.getFindById(id).subscribe(data => {
        // @ts-ignore
        this.product = data;
        if (data == null) {
          this.toast.error("Không có  sản phẩm này", 'Thông Báo!')
          this.router.navigateByUrl("/home").then()
        }
      })
    })
  }

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUserName(username).subscribe(value => {
      this.customer = value;
      if (value == null) {
        this.infoStatus = true;
      } else {
        this.infoStatus = value.appUser.isDeleted;
      }
    });
  }

  addToCart(product: Product) {
    let order: Order = {
      customer: this.customer,
      product: product,
      quantity: 1
    };
    this.orderService.addOrder(order).subscribe((po: Order) => {
      this.toast.success('Thêm thành công sản phẩm ' + po.product.name);
      this.sendMessage();
    }, error => {
      if (error.error.message == 'quantity') {
        this.toast.warning('Bạn đã thêm vượt quá số lượng sản phẩm!');
      }
    });
  }


  sendMessage(): void {
    this.commonService.sendUpdate('Success!');
  }

  minusQuantity(productOrder: Order) {
    this.orderService.minusQuantity(productOrder).subscribe(value => {
      this.productOrders = value;
      this.sendMessage();
    }, error => {
      if (error.error.message == 'minimum') {

      }
    });
  }

  maximumQuantity() {
    this.toast.warning('Số lượng sản phẩm đã tối đa.');
  }

  plusQuantity(productOrder: Order) {
    this.orderService.plusQuantity(productOrder).subscribe(value => {
      this.productOrders = value;
      this.sendMessage();
    }, error => {
      if (error.error.message == 'maximum') {
        this.toast.warning('Số lượng sản phẩm đã tối đa.');
      }
    });
  }
}
