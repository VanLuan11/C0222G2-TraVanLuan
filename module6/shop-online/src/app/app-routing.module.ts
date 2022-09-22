import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CartComponent} from './product/cart/cart.component';
import {DetailProductComponent} from './product/detail-product/detail-product.component';
import {HomeLoginComponent} from './login/home-login/home-login.component';
import {LapTopGamingComponent} from './product/lap-top-gaming/lap-top-gaming.component';
import {LapTopVanPhongComponent} from './product/lap-top-van-phong/lap-top-van-phong.component';
import {GuaranteeComponent} from './common/guarantee/guarantee.component';
import {TransportComponent} from './common/transport/transport.component';
import {HomeLapTopComponent} from './product/home-lap-top/home-lap-top.component';
import {HistoryOrderProductComponent} from "./product/history-order-product/history-order-product.component";
import {InfoCustomerComponent} from "./product/info-customer/info-customer.component";
import {CreateComponent} from "./product/create/create.component";
import {EditComponent} from "./product/edit/edit.component";
import {StatisticsComponent} from "./product/statistics/statistics.component";


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'home', component: HomeLapTopComponent},
  {path: 'cart', component: CartComponent},
  {path: 'detail/:id', component: DetailProductComponent},
  {path: 'login', component: HomeLoginComponent},
  {path: 'lapTopGaming', component: LapTopGamingComponent},
  {path: 'lapTopVP', component: LapTopVanPhongComponent},
  {path: 'baoHanh', component: GuaranteeComponent},
  {path: 'vanChuyen', component: TransportComponent},
  {path: 'historyOrder', component: HistoryOrderProductComponent},
  {path: 'infoCustomer', component: InfoCustomerComponent},
  {path: 'create', component: CreateComponent},
  {path: 'update/:id', component: EditComponent},
  {path: 'statistics', component: StatisticsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
