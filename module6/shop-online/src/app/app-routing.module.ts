import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {CartComponent} from './cart/cart.component';
import {DetailProductComponent} from './detail-product/detail-product.component';
import {HomeLoginComponent} from './login/home-login/home-login.component';



const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'home', component: HomeComponent},
  {path: 'cart', component: CartComponent},
  {path: 'detail', component: DetailProductComponent},
  {path: 'login', component: HomeLoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
