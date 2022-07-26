import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  productForm: FormGroup;
  id: number;
  p: Product;

  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService,
              private route: Router) {
    activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.p = this.productService.findById(this.id);
      this.productForm = new FormGroup({
        id: new FormControl(this.p.id),
        name: new FormControl(this.p.name),
        price: new FormControl(this.p.price),
        description: new FormControl(this.p.description),
      });
    }, error => {

    });
  }


  ngOnInit(): void {
  }

  delete() {
    this.productService.deleteProduct(this.id);
    this.route.navigateByUrl('/list');
  }
}
