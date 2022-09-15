import {Component, OnInit} from '@angular/core';
import {Customer} from "../../model/customer";
import {OrderService} from "../../service/order.service";
import {CustomerService} from "../../service/customer.service";
import {Order} from "../../model/order";
import {Subscription} from "rxjs";
import {CookieService} from "../../login/service/cookie.service";
import {CommonService} from "../../login/service/common.service";

@Component({
  selector: 'app-history-order-product',
  templateUrl: './history-order-product.component.html',
  styleUrls: ['./history-order-product.component.css']
})
export class HistoryOrderProductComponent implements OnInit {
  role: string = '';
  username: string = '';
  token: string = '';
  messageReceived: any;
  private subscriptionName: Subscription;
  public loginStatus: any;
  customer: Customer;
  productOrders: Order[] = [];
  totalMoney: number = 0;

  constructor(private cookieService: CookieService,
              private commonService: CommonService,
              private customerService: CustomerService,
              private orderService: OrderService) {
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
    this.getCustomerByUsername(this.username)
  }

  getCustomerByUsername(username: string) {
    this.customerService.getCustomerByUserName(username).subscribe(value => {
      this.customer = value;
      this.orderService.getHistoryCustomerOrderProduct(this.customer).subscribe((pos: Order[]) => {
        console.log(pos)
        if (pos != null) {
          // @ts-ignore
          this.productOrders = pos;
        } else {
          this.productOrders = [];
        }
      });
    });
  }

}
