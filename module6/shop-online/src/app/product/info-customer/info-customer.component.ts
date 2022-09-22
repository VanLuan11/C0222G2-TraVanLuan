import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {Order} from "../../model/order";
import {Customer} from "../../model/customer";
import {CookieService} from "../../login/service/cookie.service";
import {ToastrService} from "ngx-toastr";
import {LogoutService} from "../../login/service/logout.service";
import {Router} from "@angular/router";
import {CommonService} from "../../login/service/common.service";
import {OrderService} from "../../service/order.service";
import {CustomerService} from "../../service/customer.service";

@Component({
  selector: 'app-info-customer',
  templateUrl: './info-customer.component.html',
  styleUrls: ['./info-customer.component.css']
})
export class InfoCustomerComponent implements OnInit {
  role: string = '';
  username: string = '';
  token: string = '';
  customer: Customer;

  constructor(private cookieService: CookieService,
              private toastrService: ToastrService,
              private commonService: CommonService,

              private customerService: CustomerService) {
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
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
    });
  }
}
