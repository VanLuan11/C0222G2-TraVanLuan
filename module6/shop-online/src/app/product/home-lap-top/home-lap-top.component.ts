import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {ToastrService} from 'ngx-toastr';
import {Title} from '@angular/platform-browser';
import {CookieService} from '../../login/service/cookie.service';
import {Customer} from '../../model/customer';
import {CommonService} from '../../login/service/common.service';
import {OrderService} from '../../service/order.service';
// @ts-ignore
import Order = jasmine.Order;
import {Router} from '@angular/router';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-home-lap-top',
  templateUrl: './home-lap-top.component.html',
  styleUrls: ['./home-lap-top.component.css']
})
export class HomeLapTopComponent implements OnInit {
  role: string = '';
  username: string = '';
  token: string = '';

  listProduct: Product[] = [];
  product: Product = {};
  totalPages: number;
  number: number;
  countTotalPages: number[];
  id: number;
  customer: Customer;
  infoStatus: boolean = false;



  constructor(private cookieService: CookieService,
              private productService: ProductService,
              private toast: ToastrService,
              private title: Title,
              private  commonService: CommonService,
              private orderService: OrderService,
              private router: Router,
              private customerService: CustomerService) {
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
    this.title.setTitle('Tech Shop');
  }

  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }

  ngOnInit(): void {
    this.getAllProduct(0);
    this.getCustomerByUsername(this.username);
  }

  getAllProduct(page) {
    this.productService.getAllProduct(page)
      .subscribe((data: Product[]) => {
        if (data != null) {
          // @ts-ignore
          this.listProduct = data.content;
        } else {
          this.listProduct = [];
        }
        if (this.listProduct.length !== 0) {
          // @ts-ignore
          this.totalPages = data.totalPages;
          // @ts-ignore
          this.countTotalPages = new Array(data.totalPages);
          // @ts-ignore
          this.number = data.number;
          // @ts-ignore
          this.size = data.size;
        }
      });
  }

  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getAllProduct(numberPage);
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getAllProduct(numberPage);
    }
  }

  goItem(i: number) {
    this.getAllProduct(i);
  }

  showDelete(p: Product) {
    this.product = p;
  }

  deleteById(id: number) {
    this.productService.deleteProductById(id).subscribe(value => {
      this.toast.success('Xoá sản phầm thành công!');
      this.ngOnInit()
    })
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

  addToCartMessage() {
    this.toast.warning('Vui lòng đăng nhập tài khoản khách hàng để thực hiện chức năng này!');
  }

  updateInfoMessage() {
    this.router.navigateByUrl('/info').then(value => {
      this.toast.warning('Vui lòng cập nhật thông tin để mua hàng!');
    });
  }

  sendMessage(): void {
    this.commonService.sendUpdate('Success!');
  }
}
