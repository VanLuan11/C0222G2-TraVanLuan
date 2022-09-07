import {Injectable} from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {CookieService} from '../../login/service/cookie.service';
import {Product} from '../../model/product';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private URL_PRODUCT = API_URL + '/product';

  constructor(private httpClient: HttpClient, private cookieService: CookieService) {
  }

  getAllProduct(page: number) {
    return this.httpClient.get<Product[]>(this.URL_PRODUCT + '/page?page=' + page)
  }
}
