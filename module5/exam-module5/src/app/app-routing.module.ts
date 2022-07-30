import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {LoHangListComponent} from "./lohang/lo-hang-list/lo-hang-list.component";
import {LoHangCreateComponent} from "./lohang/lo-hang-create/lo-hang-create.component";
import {LoHangEditComponent} from "./lohang/lo-hang-edit/lo-hang-edit.component";


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'loHang-list'},
  {path: 'loHang-list', component: LoHangListComponent},
  {path: 'loHang-create', component: LoHangCreateComponent},
  {path: 'loHang-edit/:id', component: LoHangEditComponent},
  {path: 'home', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
