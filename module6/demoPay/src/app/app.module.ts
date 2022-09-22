import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {CKEditorModule} from "@ckeditor/ckeditor5-angular";
import { DemoChartJsComponent } from './demo-chart-js/demo-chart-js.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoChartJsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CKEditorModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
