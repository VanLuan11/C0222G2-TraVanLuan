import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TimelinesComponent} from './timelines/timelines.component';
import {ProductListComponent} from './product-management/product/product-list/product-list.component';
import {ProductCreateComponent} from './product-management/product/product-create/product-create.component';
import {ProductEditComponent} from './product-management/product/product-edit/product-edit.component';
import {ProductDeleteComponent} from './product-management/product/product-delete/product-delete.component';
import {YoutubePlaylistComponent} from './playlist/youtube-playlist/youtube-playlist.component';
import {YoutubePlayerComponent} from './playlist/youtube-playlist/youtube-player/youtube-player.component';
import {DictionaryPageComponent} from './dictionary/dictionary-page/dictionary-page.component';
import {DictionaryDetailComponent} from './dictionary/dictionary-detail/dictionary-detail.component';


const routes: Routes = [
  {path: 'list', component: ProductListComponent},
  {path: 'create', component: ProductCreateComponent},
  {path: 'edit/:id', component: ProductEditComponent},
  {path: 'delete/:id', component: ProductDeleteComponent},
  {path: 'dictionary', component: DictionaryPageComponent},
  {path: 'detail/:word', component: DictionaryDetailComponent},
  {path: 'youtube', component: YoutubePlaylistComponent, children: [{path: ':id', component: YoutubePlayerComponent}]
  }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
