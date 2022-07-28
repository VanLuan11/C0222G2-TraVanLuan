import { Injectable } from '@angular/core';
import {Customer} from "../model/customer";
import {CustomerType} from "../model/customer-type";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customer: Customer[] = [];
  customerType: CustomerType[] = [];
  private URL_CUSTOMER = "http://localhost:3000/customer";
  private URL_CUSTOMER_TYPE = " http://localhost:3000/customerType";

  constructor(private httpClient: HttpClient) {
  }

  getAllCustomer(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.URL_CUSTOMER);
  }

  getAllCustomerType(): Observable<CustomerType[]> {
    return this.httpClient.get<CustomerType[]>(this.URL_CUSTOMER_TYPE)
  }

  saveCustomer(customer: Customer) {
    return this.httpClient.post(this.URL_CUSTOMER, customer)
  }

  findById(id: number): Observable<Customer> {
    return this.httpClient.get<Customer>(this.URL_CUSTOMER + '/' + id);
  }

  deleteCustomer(idDelete: number): Observable<Customer> {
    return this.httpClient.delete(this.URL_CUSTOMER + '/' + idDelete);
  }

  updateCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient.patch(this.URL_CUSTOMER + '/' + customer.id, customer);
  }

  customerListBySearch(searchName: string, searchAddress: string): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>
    (this.URL_CUSTOMER + "?name_like=" + searchName + "&address_like=" + searchAddress);
  }
}
