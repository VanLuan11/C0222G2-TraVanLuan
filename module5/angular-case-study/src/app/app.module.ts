import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './common/header/header.component';
import { FooterComponent } from './common/footer/footer.component';
import { ListFacilityComponent } from './facility/list-facility/list-facility.component';

import { ListCustomerComponent } from './customer/list-customer/list-customer.component';
import { EditFacilityComponent } from './facility/edit-facility/edit-facility.component';
import { CreateFacilityComponent } from './facility/create-facility/create-facility.component';
import { EditCustomerComponent } from './customer/edit-customer/edit-customer.component';
import { CreateCustomerComponent } from './customer/create-customer/create-customer.component';
import { ListContractComponent } from './contract/list-contract/list-contract.component';
import { CreateContractComponent } from './contract/create-contract/create-contract.component';


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
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
