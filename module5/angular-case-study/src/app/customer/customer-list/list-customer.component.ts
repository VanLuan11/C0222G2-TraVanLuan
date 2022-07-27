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

  constructor(private customerService: CustomerService,
              private router: Router,
              private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllCustomer()
    this.formSearch()
  }

  deleteCustomer(id: number) {
    this.customerService.deleteCustomer(id).subscribe(value => {
      this.router.navigateByUrl('customer-list').then(() => {
        this.ngOnInit()
      })
    })
  }

  // showDelete(c: Customer) {
  //   this.idDelete = c.id;
  //   this.name = c.name
  //   this.phone = c.phone
  // }

  getAllCustomer() {
    this.customerService.getAllCustomer().subscribe(data => {
      this.customer = data;
    })
  }

  showToastr() {
    this.toastr.success('Delete success!', 'Tittle', {
      timeOut: 1500,
      progressBar: true,
    });
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
