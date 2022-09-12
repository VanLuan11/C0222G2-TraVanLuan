import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {CookieService} from '../login/service/cookie.service';
import {Product} from '../model/product';
import {Observable} from 'rxjs';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL_PRODUCT = API_URL + '/product';
  private header = 'Bearer ' + this.cookieService.getCookie('jwToken');

  constructor(private httpClient: HttpClient, private cookieService: CookieService) {
  }

  getAllProduct(page: number) {
    return this.httpClient.get<Product[]>(this.URL_PRODUCT + '/page?page=' + page);
  }


  getAllLapTopGaming(page: number, searchNameProduct, start, end, sort) {
    let name;
    let priceStart;
    let priceEnd;
    if (searchNameProduct == null) {
      name = '';
    } else {
      name = searchNameProduct;
    }
    if (start == null) {
      priceStart = '0';
    } else {
      priceStart = start;
    }
    if (end == null) {
      priceEnd = '4000000000';
    } else {
      priceEnd = end;
    }
    return this.httpClient.get<Product[]>(this.URL_PRODUCT + '/lapTopG?page=' + page + '&searchNameProduct=' + name + '&priceStart=' + priceStart + '&priceEnd=' + priceEnd + '&sort=' + sort);
  }

  getAllLapTopVP(page: number, searchNameProduct, start, end, sort) {
    let name;
    let priceStart;
    let priceEnd;
    if (searchNameProduct == null) {
      name = '';
    } else {
      name = searchNameProduct;
    }
    if (start == null) {
      priceStart = '0';
    } else {
      priceStart = start;
    }
    if (end == null) {
      priceEnd = '4000000000';
    } else {
      priceEnd = end;
    }
    return this.httpClient.get<Product[]>(this.URL_PRODUCT + '/lapTopVP?page=' + page + '&searchNameProduct=' + name + '&priceStart=' + priceStart + '&priceEnd=' + priceEnd + '&sort=' + sort);
  }

  getFindById(id): Observable<Product> {
    return this.httpClient.get<Product>(this.URL_PRODUCT + '/detail/' + id);
  }

  getDeleteById(id): Observable<Product> {
    return this.httpClient.get<Product>(this.URL_PRODUCT + '/delete/' + id);
  }
}
