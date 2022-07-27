import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Customer} from "../../model/customer";
import {CustomerType} from "../../model/customer-type";
import {ActivatedRoute, convertToParamMap, Router} from "@angular/router";
import {CustomerService} from "../../service/customer.service";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  customerFormEdit: FormGroup;
  customer: Customer = {};
  customerType: CustomerType[] = [];

  constructor(private activatedRoute: ActivatedRoute,
              private customerService: CustomerService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getCustomerFindById()
  }

  getCustomerFindById(){
    this.activatedRoute.paramMap.subscribe((paramMap) => {
      const idEdit = +paramMap.get('id');
      this.customerService.findById(idEdit).subscribe(customer => {
        this.customerService.getAllCustomerType().subscribe(customerType => {
          this.customerType = customerType
        }, error => {
        }, () => {
          this.customerFormEdit = new FormGroup({
            id: new FormControl(customer.id),
            name: new FormControl(customer.name),
            dateOfBirth: new FormControl(customer.dateOfBirth),
            gender: new FormControl(customer.gender),
            idCard: new FormControl(customer.idCard),
            phone: new FormControl(customer.phone),
            email: new FormControl(customer.email),
            customerType: new FormControl(customer.customerType),
            address: new FormControl(customer.address)
          })
        })
      })
    })
  }


  update(){
    console.log(this.customerFormEdit.value)
    this.customerService.updateCustomer(this.customerFormEdit.value).subscribe(value => {

    },error => {}, ()=>{
      this.router.navigateByUrl('customer-list').then(() =>{
        alert('Update success!')
      })
    })
  }
  compareCustomerType(c1: CustomerType, c2: CustomerType): boolean {
    if ((c1 && c2) != undefined) {
      console.log(c1.id === c2.id);
      return c1.id === c2.id;
    }
  }
}
