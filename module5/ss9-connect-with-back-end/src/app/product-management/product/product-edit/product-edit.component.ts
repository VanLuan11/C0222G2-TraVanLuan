import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {ProductService} from "../../service/product.service";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  categories: Category[] = [];
  product: Product = {};
  productFormEdit: FormGroup;

  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {

  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap) => {
      const id = +paramMap.get('id');
      this.productService.findById(id).subscribe(product => {
        this.categoryService.getAll().subscribe(category => {
          this.categories = category;
        }, error => {
        }, () => {
          this.productFormEdit = new FormGroup({
            id: new FormControl(product.id),
            name: new FormControl(product.name),
            price: new FormControl(product.price),
            description: new FormControl(product.description),
            category: new FormControl(product.category)
          });
        })
      })
    });
  }

  submit() {
    console.log(this.productFormEdit.value)
    this.productService.updateProduct(this.productFormEdit.value).subscribe(value => {
      this.router.navigateByUrl("list").then(() => {
        alert("Edit success!");
      })
    });
  }

  compareCategory(c1: Category, c2: Category): boolean {
    if ((c1 && c2) != undefined) {
      console.log(c1.id === c2.id);
      return c1.id === c2.id;
    }
  }

}
