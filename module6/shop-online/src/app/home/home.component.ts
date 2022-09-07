import {Component, OnInit} from '@angular/core';
import {ProductService} from './service/product.service';
import {ToastrService} from 'ngx-toastr';
import {Title} from '@angular/platform-browser';
import {Product} from '../model/product';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  listProduct: Product[] = [];
  totalPages: number;
  number: number;
  countTotalPages: number[];

  constructor(private productService: ProductService, private toast: ToastrService,
              private title: Title) {
    this.title.setTitle('Tech Toys Shop');
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
