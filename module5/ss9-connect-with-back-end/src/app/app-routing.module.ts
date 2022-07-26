import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from "./product-management/product/product-list/product-list.component";
import {ProductCreateComponent} from "./product-management/product/product-create/product-create.component";
import {ProductEditComponent} from "./product-management/product/product-edit/product-edit.component";
import {ProductDeleteComponent} from "./product-management/product/product-delete/product-delete.component";


const routes: Routes = [
  {path: 'list', component: ProductListComponent},
  {path: 'create', component: ProductCreateComponent},
  {path: 'edit/:id', component: ProductEditComponent},
  {path: 'delete/:id', component: ProductDeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
