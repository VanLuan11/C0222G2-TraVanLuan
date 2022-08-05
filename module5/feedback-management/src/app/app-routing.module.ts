import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FeedbackComponent} from "./feedback/feedback.component";


const routes: Routes = [
  {path:'',pathMatch:'full', redirectTo:'list'},
  {path: 'list', component: FeedbackComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
