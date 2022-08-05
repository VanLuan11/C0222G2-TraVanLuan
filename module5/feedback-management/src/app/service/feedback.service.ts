import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Feedback} from "../model/feedback";

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  private URL_FEEDBACK = "http://localhost:3000/feedback"

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Feedback[]> {
    return this.httpClient.get<Feedback[]>(this.URL_FEEDBACK);
  }
}
