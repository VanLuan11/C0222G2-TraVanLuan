import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './common/header/header.component';
import {FooterComponent} from './common/footer/footer.component';
import {DetailProductComponent} from './product/detail-product/detail-product.component';
import {CartComponent} from './product/cart/cart.component';
import {ChartsModule} from 'ng2-charts';
import {ToastrModule} from 'ngx-toastr';
import {HttpClientModule} from '@angular/common/http';
import {LoginModule} from './login/login.module';
import { LapTopGamingComponent } from './product/lap-top-gaming/lap-top-gaming.component';
import { LapTopVanPhongComponent } from './product/lap-top-van-phong/lap-top-van-phong.component';
import { HomeLapTopComponent } from './product/home-lap-top/home-lap-top.component';
import { GuaranteeComponent } from './common/guarantee/guarantee.component';
import { TransportComponent } from './common/transport/transport.component';
import {ReactiveFormsModule} from '@angular/forms';
import { CreateComponent } from './product/create/create.component';
import { EditComponent } from './product/edit/edit.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DetailProductComponent,
    CartComponent,
    LapTopGamingComponent,
    LapTopVanPhongComponent,
    HomeLapTopComponent,
    GuaranteeComponent,
    TransportComponent,
    CreateComponent,
    EditComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ChartsModule,
    HttpClientModule,
    LoginModule,
    ToastrModule.forRoot(
      {
        timeOut: 2000,
        closeButton: true,
        progressBar: true,
        positionClass: 'toast-top-right',
        preventDuplicates: true,
      }
    ),
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
