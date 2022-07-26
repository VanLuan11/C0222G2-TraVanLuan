import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [];
  private URL_PRODUCT = "http://localhost:3000/product";

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.URL_PRODUCT);
  }

  saveProduct(product: Product) {
    return this.httpClient.post(this.URL_PRODUCT, product)
  }

  findById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(this.URL_PRODUCT +'/'+ id);
  }

  delete(idDelete: number): Observable<Product> {
    return  this.httpClient.delete(this.URL_PRODUCT + '/' + idDelete);
  }

  updateProduct(product: Product): Observable<Product> {
    return this.httpClient.patch(this.URL_PRODUCT + '/' + product.id, product);
  }
}
