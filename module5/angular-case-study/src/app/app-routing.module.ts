import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {ListFacilityComponent} from "./facility/facility-list/list-facility.component";
import {CreateFacilityComponent} from "./facility/facility-create/create-facility.component";
import {EditFacilityComponent} from "./facility/facility-edit/edit-facility.component";
import {ListCustomerComponent} from "./customer/customer-list/list-customer.component";
import {EditCustomerComponent} from "./customer/customer-edit/edit-customer.component";
import {CreateCustomerComponent} from "./customer/customer-create/create-customer.component";
import {ListContractComponent} from "./contract/contract-list/list-contract.component";
import {CreateContractComponent} from "./contract/contract-create/create-contract.component";


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'home', component: HomeComponent},
  {path: 'facility-list', component: ListFacilityComponent},
  {path: 'facility-create', component: CreateFacilityComponent},
  {path: 'facility-edit', component: EditFacilityComponent},
  {path: 'customer-list', component: ListCustomerComponent},
  {path: 'customer-create', component: CreateCustomerComponent},
  {path: 'customer-edit', component: EditCustomerComponent},
  {path: 'contract-list', component: ListContractComponent},
  {path: 'contract-create', component: CreateContractComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
