import { Component, OnInit } from '@angular/core';
import {Product} from '../model/product';
import {ProductService} from '../service/product.service';
import {ToastrService} from 'ngx-toastr';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-lap-top-van-phong',
  templateUrl: './lap-top-van-phong.component.html',
  styleUrls: ['./lap-top-van-phong.component.css']
})
export class LapTopVanPhongComponent implements OnInit {

  listProduct: Product[] = [];

  constructor(private productService: ProductService, private toast: ToastrService,
              private title: Title) {
    this.title.setTitle('Tech Shop');
  }

  ngOnInit(): void {
    this.getAllProduct()
  }

  getAllProduct() {
    this.productService.getAllLapTopVanPhong().subscribe((data: Product[]) => {
      this.listProduct = data;
    });
  }


}
