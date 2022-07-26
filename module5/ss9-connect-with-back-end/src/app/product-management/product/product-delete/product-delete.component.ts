import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Product} from "../../model/product";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {ProductService} from "../../service/product.service";
import {Category} from "../../model/category";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {

  categories: Category[] = [];
  product: Product = {};
  productFormDelete: FormGroup;
  id: number;

  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }


  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap) => {
      const id = +paramMap.get('id');
      this.getProduct(id)
    });
  }

  getProduct(id: number) {
    return this.productService.findById(id).subscribe(product => {
      this.categoryService.getAll().subscribe(category => {
        this.categories = category;
      }, error => {
      }, () => {
        this.productFormDelete = new FormGroup({
          id: new FormControl(product.id),
          name: new FormControl(product.name),
          price: new FormControl(product.price),
          description: new FormControl(product.description),
          category: new FormControl(product.category)
        });
      })
    });
  }

  delete(id: number) {
    this.productService.delete(id).subscribe(() => {
      this.router.navigateByUrl('list').then(() =>{
        alert('Delete success!')
      } );
    }, error => {
      console.log(error);
    });
  }


  compareCategory(c1: Category, c2: Category): boolean {
    if ((c1 && c2) != undefined) {
      console.log(c1.id === c2.id);
      return c1.id === c2.id;
    }
  }

}
