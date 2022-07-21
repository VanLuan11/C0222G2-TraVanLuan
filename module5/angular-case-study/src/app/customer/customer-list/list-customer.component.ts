import {Component, OnInit} from '@angular/core';
import {Customer} from "../customer";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customer: Customer[] = [];

  constructor() {
    this.customer.push({id: 1, name: 'tài ngu', dateOfBirth: '2001-03-08', gender: 'nữ', idCard: 1234566, phone: 333333,
      email: 'tainguvldn@gmail.com', customerType:'dưới đáy xã hội', address:'khu ô chuột'})
    this.customer.push({id: 2, name: 'gà tài', dateOfBirth: '2001-03-08', gender: 'nữ', idCard: 1234566, phone: 333333,
      email: 'tainguvldn@gmail.com', customerType:'dưới đáy xã hội', address:'khu ô chuột'})
    this.customer.push({id: 3, name: 'tài nô lệ', dateOfBirth: '2001-03-08', gender: 'nữ', idCard: 1234566, phone: 333333,
      email: 'tainguvldn@gmail.com', customerType:'dưới đáy xã hội', address:'khu ô chuột'})
  }

  ngOnInit(): void {
  }



}
