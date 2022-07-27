import {Component, OnInit} from '@angular/core';
import {CustomerType} from "../../model/customer-type";
import {Customer} from "../../model/customer";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerService} from "../../service/customer.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  customerType: CustomerType[] = [];
  customer: Customer;
  customerFormCreate: FormGroup;

  constructor(private activatedRoute: ActivatedRoute,
              private customerService: CustomerService,
              private router: Router) {
  }

  ngOnInit() {
    this.customerService.getAllCustomerType().subscribe(data => {
      this.customerType = data;
    },error => {}, ()=>{
      this.customerFormCreate = new FormGroup({
        name: new FormControl('',[Validators.required, Validators.pattern('^([A-Z][^A-Z0-9\s]+)(\s[A-Z][^A-Z0-9\s]+)*$')]),
        dateOfBirth: new FormControl('',[Validators.required]),
        gender: new FormControl('',[Validators.required]),
        idCard: new FormControl('',[Validators.required, Validators.pattern('^[0-9]{6,9}$')]),
        phone: new FormControl('',[Validators.required, Validators.pattern('^[\+84][0-9]{9,10}$')]),
        email: new FormControl('',[Validators.required, Validators.email]),
        customerType: new FormControl('',[Validators.required]),
        address: new FormControl('',[Validators.required]),
      })
    })
  }
  create() {
    console.log(this.customerFormCreate.value);
    if (this.customerFormCreate.valid){
      this.customerService.saveCustomer(this.customerFormCreate.value).subscribe(data => {
        this.router.navigateByUrl("/customer-list").then(() => {
          alert("Create success!");
        })
      });
    }else {
     alert('Bạn phải nhập thông tin mới đươc')
    }
  }
}
