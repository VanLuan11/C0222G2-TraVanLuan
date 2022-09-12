import { Component, OnInit } from '@angular/core';
import {Product} from '../model/product';
import {ProductService} from '../service/product.service';
import {ToastrService} from 'ngx-toastr';
import {Title} from '@angular/platform-browser';
import {CookieService} from '../login/service/cookie.service';

@Component({
  selector: 'app-home-lap-top',
  templateUrl: './home-lap-top.component.html',
  styleUrls: ['./home-lap-top.component.css']
})
export class HomeLapTopComponent implements OnInit {
  role: string = '';
  username: string = '';
  token: string = '';

  listProduct: Product[] = [];
  totalPages: number;
  number: number;
  countTotalPages: number[];

  constructor(private cookieService: CookieService,
              private productService: ProductService,
              private toast: ToastrService,
              private title: Title) {
    this.role = this.readCookieService('role');
    this.username = this.readCookieService('username');
    this.token = this.readCookieService('jwToken');
    this.title.setTitle('Tech Shop');
  }
  readCookieService(key: string): string {
    return this.cookieService.getCookie(key);
  }

  ngOnInit(): void {
    this.getAllProduct(0)
  }

  getAllProduct(page: number) {
    this.productService.getAllProduct(page)
      .subscribe((data: Product[]) => {
        if (data != null) {
          // @ts-ignore
          this.listProduct = data.content;
        } else {
          this.listProduct = [];
        }
        if (this.listProduct.length !== 0) {
          // @ts-ignore
          this.totalPages = data.totalPages;
          // @ts-ignore
          this.countTotalPages = new Array(data.totalPages);
          // @ts-ignore
          this.number = data.number;
          // @ts-ignore
          this.size = data.size;
        }
      });
  }

  goPrevious() {
    let numberPage: number = this.number;
    if (numberPage > 0) {
      numberPage--;
      this.getAllProduct(numberPage);
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getAllProduct(numberPage);
    }
  }

  goItem(i: number) {
    this.getAllProduct(i);
  }

}
