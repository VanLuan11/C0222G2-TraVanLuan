import { Injectable } from '@angular/core';
import {HttpHandler, HttpRequest} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class BasicAuthHtppInterceptorServiceService {

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler) {

    if (sessionStorage.getItem('username') && sessionStorage.getItem('token')) {
      req = req.clone({
        setHeaders: {
          Authorization: sessionStorage.getItem('token')
        }
      })
    }

    return next.handle(req);

  }
}
