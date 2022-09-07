import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CartComponent} from './cart/cart.component';
import {DetailProductComponent} from './detail-product/detail-product.component';
import {HomeLoginComponent} from './login/home-login/home-login.component';
import {LapTopGamingComponent} from './lap-top-gaming/lap-top-gaming.component';
import {LapTopVanPhongComponent} from './lap-top-van-phong/lap-top-van-phong.component';
import {HomeLapTopComponent} from './home-lap-top/home-lap-top.component';



const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'home', component: HomeLapTopComponent},
  {path: 'cart', component: CartComponent},
  {path: 'detail', component: DetailProductComponent},
  {path: 'login', component: HomeLoginComponent},
  {path: 'lapTopGaming', component: LapTopGamingComponent},
  {path: 'lapTopVP', component: LapTopVanPhongComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
