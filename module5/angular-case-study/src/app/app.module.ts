import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './common/header/header.component';
import { FooterComponent } from './common/footer/footer.component';
import { ListFacilityComponent } from './facility/facility-list/list-facility.component';

import { ListCustomerComponent } from './customer/customer-list/list-customer.component';
import { EditFacilityComponent } from './facility/facility-edit/edit-facility.component';
import { CreateFacilityComponent } from './facility/facility-create/create-facility.component';
import { EditCustomerComponent } from './customer/customer-edit/edit-customer.component';
import { CreateCustomerComponent } from './customer/customer-create/create-customer.component';
import { ListContractComponent } from './contract/contract-list/list-contract.component';
import { CreateContractComponent } from './contract/contract-create/create-contract.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    ListFacilityComponent,
    ListCustomerComponent,
    EditFacilityComponent,
    CreateFacilityComponent,
    EditCustomerComponent,
    CreateCustomerComponent,
    ListContractComponent,
    CreateContractComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
