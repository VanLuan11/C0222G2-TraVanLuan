import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {Customer} from '../model/customer';
const APL_URL = `${environment.apiUrl}`
@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private URL_CONNECT = APL_URL + '/rest';

  constructor(private httpClient: HttpClient) { }

  addOrder(productOrder: OrderService): Observable<OrderService> {
    // @ts-ignore
    return this.httpClient.post(this.URL_CONNECT + "/add/cart", productOrder);
  }

  getProductInCardByCustomer(customer: Customer): Observable<OrderService[]> {
    return this.httpClient.post<OrderService[]>(this.URL_CONNECT+ "/cart/products", customer);
  }

  minusQuantity(productOrder: OrderService): Observable<OrderService[]> {
    return this.httpClient.post<OrderService[]>(this.URL_CONNECT + "/cart/minus/quantity", productOrder);
  }

  plusQuantity(productOrder: OrderService): Observable<OrderService[]> {
    return this.httpClient.post<OrderService[]>(this.URL_CONNECT + "/cart/plus/quantity", productOrder);
  }

  deleteProductInCard(po: OrderService):Observable<any> {
    return this.httpClient.post(this.URL_CONNECT + "/cart/delete", po);
  }

  goPayment(customer: Customer): Observable<any> {
    return this.httpClient.post(this.URL_CONNECT + "/cart/payment", customer);
  }
}
