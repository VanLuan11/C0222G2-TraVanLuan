import {Component, OnInit} from '@angular/core';
import {Customer} from "../../model/customer";
import {CustomerService} from "../../service/customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customer: Customer[] = [];
  idDelete: number;
  name: string;
  phone: string;
  p: number = 1;

  constructor(private customerService: CustomerService,
              private router: Router) {
  }

  ngOnInit(): void {
   this.getAllCustomer()
  }

  deleteCustomer() {
    this.customerService.deleteCustomer(this.idDelete).subscribe(value => {
      this.router.navigateByUrl('customer-list').then(() => {
        this.ngOnInit()
      })
    })
  }

  showDelete(c: Customer) {
    this.idDelete = c.id;
    this.name = c.name
    this.phone = c.phone
  }
  getAllCustomer(){
    this.customerService.getAllCustomer().subscribe(data => {
      this.customer = data;
    })
  }
}
