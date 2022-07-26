import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TodoComponent} from './todo/todo.component';
import {TodoEditComponent} from './todo-edit/todo-edit.component';
import {TodoDeleteComponent} from './todo-delete/todo-delete.component';


const routes: Routes = [
  {path: 'list', component: TodoComponent},
  {path: 'edit/:id', component: TodoEditComponent},
  {path: 'delete/:id', component: TodoDeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
