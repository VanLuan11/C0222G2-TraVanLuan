import {Component, OnInit} from '@angular/core';
import {Customer} from "../../model/customer";
import {CustomerService} from "../../service/customer.service";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customer: Customer[] = [];
  p: number = 1;
  searchForm: FormGroup;
  idDelete: number;
  name: string;
  phone: string;

  constructor(private customerService: CustomerService,
              private router: Router,
              private toastr: ToastrService) {
  }

  showToastr() {
    this.toastr.success('Success!', 'Delete', {
      timeOut: 1000,
      progressBar: true,
    });
  }

  ngOnInit(): void {
    this.getAllCustomer()
    this.formSearch()
  }

  getAllCustomer() {
    this.customerService.getAllCustomer().subscribe(data => {
      this.customer = data;
    })
  }

  showDelete(customer: Customer) {
    this.idDelete = customer.id;
    this.name = customer.name
    this.phone = customer.phone
  }

  deleteCustomer(idDelete) {
    this.customerService.deleteCustomer(idDelete).subscribe(value => {
      this.router.navigateByUrl('customer-list').then(() => {
        this.ngOnInit()
      })
    })
  }

  formSearch() {
    this.searchForm = new FormGroup({
      searchName: new FormControl(""),
      searchIdCard: new FormControl("")
    });
  }

  getFormSearch() {
    this.customerService.customerListBySearch(this.searchForm.value.searchName, this.searchForm.value.searchIdCard).subscribe(data => {
      this.customer = data;
      console.log(data);
    })
  }
}
