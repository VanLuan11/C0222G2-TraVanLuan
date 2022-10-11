import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Customer} from "../model/customer";
import {Observable} from "rxjs";
import {Order} from "../model/order";
import {Statistics} from "../model/statistics";

const APL_URL = `${environment.apiUrl}`

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private URL_CONNECT = APL_URL + '/rest';

  constructor(private httpClient: HttpClient) { }

  addOrder(productOrder: Order): Observable<Order> {
    return this.httpClient.post(this.URL_CONNECT + "/add/cart", productOrder);
  }

  getProductInCardByCustomer(customer: Customer): Observable<Order[]> {
    return this.httpClient.post<Order[]>(this.URL_CONNECT+ "/cart/products", customer);
  }

  minusQuantity(productOrder: Order): Observable<Order[]> {
    return this.httpClient.post<Order[]>(this.URL_CONNECT + "/cart/minus/quantity", productOrder);
  }

  plusQuantity(productOrder: Order): Observable<Order[]> {
    return this.httpClient.post<Order[]>(this.URL_CONNECT + "/cart/plus/quantity", productOrder);
  }

  deleteProductInCard(po: Order):Observable<any> {
    return this.httpClient.post(this.URL_CONNECT + "/cart/delete", po);
  }

  goPayment(customer: Customer): Observable<any> {
    return this.httpClient.post(this.URL_CONNECT + "/cart/payment", customer);
  }

  getHistoryCustomerOrderProduct(customer: Customer): Observable<Order[]> {
    return this.httpClient.post<Order[]>(this.URL_CONNECT+ "/cart/history", customer);
  }
  getStatisticsWeek(): Observable<Statistics[]> {
    return this.httpClient.get<Statistics[]>(this.URL_CONNECT+ "/statistics/week")
  }
  getStatisticsMonth(): Observable<Statistics[]> {
    return this.httpClient.get<Statistics[]>(this.URL_CONNECT+ "/statistics/month")
  }
  getStatisticsYear(): Observable<Statistics[]> {
    return this.httpClient.get<Statistics[]>(this.URL_CONNECT+ "/statistics/year")
  }
  getStatisticsCustomer(): Observable<Statistics[]> {
    return this.httpClient.get<Statistics[]>(this.URL_CONNECT+ "/statistics/customer")
  }
}
