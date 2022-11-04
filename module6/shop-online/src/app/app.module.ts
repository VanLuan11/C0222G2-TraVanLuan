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
import {LapTopGamingComponent} from './product/lap-top-gaming/lap-top-gaming.component';
import {LapTopVanPhongComponent} from './product/lap-top-van-phong/lap-top-van-phong.component';
import {HomeLapTopComponent} from './product/home-lap-top/home-lap-top.component';
import {GuaranteeComponent} from './common/guarantee/guarantee.component';
import {TransportComponent} from './common/transport/transport.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CreateComponent} from './product/create/create.component';
import {EditComponent} from './product/edit/edit.component';
import {HistoryOrderProductComponent} from './product/history-order-product/history-order-product.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {InfoCustomerComponent} from './product/info-customer/info-customer.component';
import {AngularFireModule} from "@angular/fire";
import {environment} from "../environments/environment";
import {AngularFireStorageModule} from "@angular/fire/storage";
import {CKEditorModule} from "@ckeditor/ckeditor5-angular";
import {StatisticsComponent} from './product/statistics/statistics.component';
import {StatisticsCustomerComponent} from './product/statistics-customer/statistics-customer.component';
import { SocialLoginModule, SocialAuthServiceConfig } from 'angularx-social-login';
import {
  GoogleLoginProvider
} from 'angularx-social-login';


const googleLoginOptions = {
  scope: 'profile email',
  plugin_name:'sample_pwa_login'
};

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
    HistoryOrderProductComponent,
    InfoCustomerComponent,
    StatisticsComponent,
    StatisticsCustomerComponent,
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    ChartsModule,
    HttpClientModule,
    LoginModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireStorageModule,
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
    CKEditorModule,
    FormsModule,
    SocialLoginModule
  ],
  providers: [
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(
              '1099484472297-9e2v2ldb47ukeggjr2c0smp04tg46trg.apps.googleusercontent.com', googleLoginOptions
            )
          }
        ],
        onError: (err) => {
          console.error(err);
        }
      } as SocialAuthServiceConfig,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
