import {Injectable} from '@angular/core';
import {Todo} from '../model/todo';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private URL_TODO = 'http://localhost:3000/todo';

  constructor(private httpClient: HttpClient) {
  }

  create(todo) {
    return this.httpClient.post(this.URL_TODO, todo);
  }

  findById(id: number): Observable<Todo> {
    return this.httpClient.get<Todo>(this.URL_TODO + '/' + id);
  }

  updateTodo(todo) {
    return this.httpClient.patch(this.URL_TODO + '/' + todo.id, todo);
  }

  deleteTodo(id) {
    return this.httpClient.delete(this.URL_TODO + '/' + id);
  }
}
