import { Component, OnInit } from '@angular/core';
import {CustomerType} from "../../model/customer-type";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerService} from "../../service/customer.service";
import {Customer} from "../../model/customer";

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  customerFormEdit: FormGroup;
  customer: Customer = {};
  customerType: CustomerType[] = [];

  constructor(private activatedRoute: ActivatedRoute,
              private customerService: CustomerService,
              private router: Router,
              private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.getCustomerFindById()
  }

  getCustomerFindById() {
    this.activatedRoute.paramMap.subscribe((paramMap) => {
      const idEdit = +paramMap.get('id');
      this.customerService.findById(idEdit).subscribe(customer => {
        this.customerService.getAllCustomerType().subscribe(customerType => {
          this.customerType = customerType
        }, error => {
        }, () => {
          this.customerFormEdit = new FormGroup({
            id: new FormControl(customer.id),
            name: new FormControl(customer.name, [Validators.required, Validators.pattern(/^([A-Z][^A-Z0-9\s]+)(\s[A-Z][^A-Z0-9\s]+)*$/)]),
            dateOfBirth: new FormControl(customer.dateOfBirth, [Validators.required]),
            gender: new FormControl(customer.gender, [Validators.required]),
            customerType: new FormControl(customer.customerType, [Validators.required]),
            address: new FormControl(customer.address, [Validators.required]),
          })
        })
      })
    })
  }


  update() {
    console.log(this.customerFormEdit.value)
    if(this.customerFormEdit.valid){
      this.customerService.updateCustomer(this.customerFormEdit.value).subscribe(value => {
        this.router.navigateByUrl('customer-list').then(() => {
        })
      })
    }
  }

  compareCustomerType(c1: CustomerType, c2: CustomerType): boolean {
    if ((c1 && c2) != undefined) {
      console.log(c1.id === c2.id);
      return c1.id === c2.id;
    }
  }

  showToastr() {
    this.toastr.success('Success', 'Update', {
      timeOut: 1000,
      progressBar: true,
    });
  }

}
