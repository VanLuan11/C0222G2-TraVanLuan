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
    this.customer.push({
      id: 1, name: 'tài ngu', dateOfBirth: '2001-03-08', gender: 0, idCard: 1234566, phone: 333333,
      email: 'tainguvldn@gmail.com', customerType: 3, address: 'khu đại gia '
    })
    this.customer.push({
      id: 2, name: 'gà tài', dateOfBirth: '2001-03-08', gender: 1, idCard: 1234566, phone: 333333,
      email: 'tainguvldn@gmail.com', customerType: 0, address: 'khu ô chuột'
    })
    this.customer.push({
      id: 3, name: 'tài nô lệ', dateOfBirth: '2001-03-08', gender: 2, idCard: 1234566, phone: 333333,
      email: 'tainguvldn@gmail.com', customerType: 1, address:'khu phố thường'})
    }

    ngOnInit()
  :
    void {}


  }
