import {Injectable} from '@angular/core';
import {Category} from "../model/category";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  categories: Category[] = [];
  private URL_CATEGORY = "http://localhost:3000/category";

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.URL_CATEGORY);
  }
}
