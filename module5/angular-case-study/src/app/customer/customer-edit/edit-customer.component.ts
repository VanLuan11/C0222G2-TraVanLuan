import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Customer} from "../../model/customer";
import {CustomerType} from "../../model/customer-type";
import {ActivatedRoute, convertToParamMap, Router} from "@angular/router";
import {CustomerService} from "../../service/customer.service";
import {ToastrService} from "ngx-toastr";

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
            idCard: new FormControl(customer.idCard, [Validators.required, Validators.pattern(/^[0-9]{6,9}$/)]),
            phone: new FormControl(customer.phone, [Validators.required, Validators.pattern(/^[84][0-9]{9,10}$/)]),
            email: new FormControl(customer.email, [Validators.required, Validators.email]),
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
