import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/product';
import {ActivatedRoute, convertToParamMap, ParamMap, Router} from '@angular/router';
import {ProductService} from '../../service/product.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

  productForm: FormGroup;
  id: number;
  p: Product;

  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService, private router: Router) {
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

  edit() {
    const p = this.productForm.value;
    this.productForm.reset();
    console.log(p);
    this.productService.editProduct(this.id, p);
    this.router.navigateByUrl('/list');
  }

}
