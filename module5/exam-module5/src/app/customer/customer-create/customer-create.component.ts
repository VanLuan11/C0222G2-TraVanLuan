import { Component, OnInit } from '@angular/core';
import {CustomerType} from "../../model/customer-type";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Customer} from "../../model/customer";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerService} from "../../service/customer.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  customerType: CustomerType[] = [];
  customer: Customer;
  customerFormCreate: FormGroup;

  constructor(private activatedRoute: ActivatedRoute,
              private customerService: CustomerService,
              private router: Router,
              private toastr: ToastrService) {
  }

  ngOnInit() {
    this.createValidate()
  }

  createValidate() {
    this.customerService.getAllCustomerType().subscribe(data => {
      this.customerType = data;
    }, error => {
    }, () => {
      this.customerFormCreate = new FormGroup({
        name: new FormControl('', [Validators.required, Validators.pattern(/^([A-Z][^A-Z0-9\s]+)(\s[A-Z][^A-Z0-9\s]+)*$/)]),
        dateOfBirth: new FormControl('', [Validators.required]),
        gender: new FormControl('', [Validators.required]),
        customerType: new FormControl('', [Validators.required]),
        address: new FormControl('', [Validators.required]),
      })
    })
  }

  create() {
    console.log(this.customerFormCreate.value);
    if (this.customerFormCreate.valid) {
      this.customerService.saveCustomer(this.customerFormCreate.value).subscribe(data => {
        this.router.navigateByUrl("customer-list").then(() => {
        })
      })
    }
  }

  showToastr() {
    this.toastr.success('Success!', 'Create', {
      timeOut:1000,
      progressBar: true,

    });
  }

}
