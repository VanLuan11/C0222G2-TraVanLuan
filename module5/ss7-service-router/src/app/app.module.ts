import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TimelinesComponent } from './timelines/timelines.component';
import { ProductCreateComponent } from './product-management/product/product-create/product-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import {ProductListComponent} from './product-management/product/product-list/product-list.component';
import { ProductDeleteComponent } from './product-management/product/product-delete/product-delete.component';
import { ProductEditComponent } from './product-management/product/product-edit/product-edit.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { YoutubePlaylistComponent } from './playlist/youtube-playlist/youtube-playlist.component';
import { YoutubePlayerComponent } from './playlist/youtube-playlist/youtube-player/youtube-player.component';
import { DictionaryPageComponent } from './dictionary/dictionary-page/dictionary-page.component';
import { DictionaryDetailComponent } from './dictionary/dictionary-detail/dictionary-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    TimelinesComponent,
    ProductCreateComponent,
    ProductListComponent,
    ProductDeleteComponent,
    ProductEditComponent,
    PlaylistComponent,
    YoutubePlaylistComponent,
    YoutubePlayerComponent,
    DictionaryPageComponent,
    DictionaryDetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
