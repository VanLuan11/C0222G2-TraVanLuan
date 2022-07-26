import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";
import {ActivatedRoute, Route, Router} from "@angular/router";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup;
  product: Product = {};
  categories: Category[] = [];


  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService,
              private categoryService: CategoryService,
              private router: Router) {

  }

  ngOnInit() {
    this.categoryService.getAll().subscribe(data => {
      this.categories = data;
    }, error => {
    }, () => {
      this.productForm = new FormGroup({
        name: new FormControl(),
        price: new FormControl(),
        description: new FormControl(),
        category: new FormControl()
      });
    })
  }

  submit() {
    console.log(this.productForm.value);
    this.productService.saveProduct(this.productForm.value).subscribe(data => {
      this.router.navigateByUrl("list").then(() => {
        alert("Create success!");
      })
    });
  }
}
