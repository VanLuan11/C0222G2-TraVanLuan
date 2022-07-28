import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerCreateComponent} from "./customer/customer-create/customer-create.component";
import {CustomerListComponent} from "./customer/customer-list/customer-list.component";
import {CustomerEditComponent} from "./customer/customer-edit/customer-edit.component";


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'customer-list'},
  {path: 'customer-list', component: CustomerListComponent},
  {path: 'customer-create', component: CustomerCreateComponent},
  {path: 'customer-edit/:id', component: CustomerEditComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
