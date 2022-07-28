import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";
import {Customer} from "../../model/customer";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customer: Customer[] = [];
  p: number = 1;
  searchForm: FormGroup;
  idDelete: number;
  name: string;
  address: string;

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
    this.address = customer.address
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
      searchAddress: new FormControl("")
    });
  }

  getFormSearch() {
    this.customerService.customerListBySearch(this.searchForm.value.searchName, this.searchForm.value.searchAddress).subscribe(data => {
      this.customer = data;
      console.log(data);
    })
  }
}
