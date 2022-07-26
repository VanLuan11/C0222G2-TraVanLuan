import { Component, OnInit } from '@angular/core';
import {Todo} from "../todo/model/todo";
import {TodoService} from "../todo/service/todo.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-todo-delete',
  templateUrl: './todo-delete.component.html',
  styleUrls: ['./todo-delete.component.css']
})
export class TodoDeleteComponent implements OnInit {

  todo: Todo = {};

  constructor(private todoService: TodoService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = +paramMap.get('id');
      this.todoService.findById(id).subscribe(data => {
        this.todo = data;
      });
    }, error => {
      console.log(error);
    });
  }

  deleteTodo(id) {
    this.todoService.deleteTodo(id).subscribe(data => {
    }, error => {
    }, () => {
      this.router.navigateByUrl('/todo');
    });
  }
}
