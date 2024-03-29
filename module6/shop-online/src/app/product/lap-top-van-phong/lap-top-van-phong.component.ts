import { Component, OnInit } from '@angular/core';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {ToastrService} from 'ngx-toastr';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-lap-top-van-phong',
  templateUrl: './lap-top-van-phong.component.html',
  styleUrls: ['./lap-top-van-phong.component.css']
})
export class LapTopVanPhongComponent implements OnInit {

  listProduct: Product[] = [];
  totalPages: number;
  number: number;
  countTotalPages: number[];
  priceStart: string;
  priceEnd: string;
  searchName: string;
  sortProductNew: string;

  constructor(private productService: ProductService, private toast: ToastrService,
              private title: Title) {
    this.title.setTitle('LapTop Gaming');
  }

  ngOnInit(): void {
    this.getAllLapTopVP(0, this.searchName, this.priceStart, this.priceEnd, 'id,ASC');
  }

  getAllLapTopVP(page: number, searchName, priceStart, priceEnd, sort) {
    this.productService.getAllLapTopVP(page, searchName, priceStart, priceEnd, sort)
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
      this.getAllLapTopVP(numberPage, this.searchName, this.priceStart, this.priceEnd, 'id,ASC');
    }
  }

  goNext() {
    let numberPage: number = this.number;
    if (numberPage < this.totalPages - 1) {
      numberPage++;
      this.getAllLapTopVP(numberPage, this.searchName, this.priceStart, this.priceEnd, 'id,ASC');
    }
  }

  goItem(i: number) {
    this.getAllLapTopVP(i, this.searchName, this.priceStart, this.priceEnd, 'id,ASC');
  }

  filterPrice(begin: string, end: string) {
    this.priceStart = begin;
    this.priceEnd = end;
    this.getAllLapTopVP(0, this.searchName, this.priceStart, this.priceEnd, 'id,ASC');
  }

  filterOrigin(searchName: string) {
    this.searchName = searchName;
    this.getAllLapTopVP(0, this.searchName, this.priceStart, this.priceEnd, 'id,ASC');
  }

  sortProduct(sortProductNew: string) {
    this.sortProductNew = sortProductNew;
    this.getAllLapTopVP(0, this.searchName, this.priceStart, this.priceEnd, this.sortProductNew);
  }
}
