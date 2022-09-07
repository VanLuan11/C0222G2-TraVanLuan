import {Component, OnInit} from '@angular/core';
import {Product} from '../model/product';
import {ProductService} from '../home/service/product.service';
import {ToastrService} from 'ngx-toastr';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-lap-top-gaming',
  templateUrl: './lap-top-gaming.component.html',
  styleUrls: ['./lap-top-gaming.component.css']
})
export class LapTopGamingComponent implements OnInit {

  listProduct: Product[] = [];

  constructor(private productService: ProductService, private toast: ToastrService,
              private title: Title) {
    this.title.setTitle('Tech Shop');
  }

  ngOnInit(): void {
    this.getAllProduct();
  }

  getAllProduct() {
    this.productService.getAllLapTopGaming().subscribe((data: Product[]) => {
      this.listProduct = data;
    });
  }

}
