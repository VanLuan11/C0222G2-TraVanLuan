import { Component, OnInit } from '@angular/core';
import {FeedbackService} from "../service/feedback.service";
import {Feedback} from "../model/feedback";

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  feedback: Feedback[]=[];
  p: number=0;
  constructor(private feedbackService: FeedbackService) { }

  ngOnInit() {
    this.getAll()
  }

  getAll(){
    this.feedbackService.getAll().subscribe(data=>{
      this.feedback = data
    })
  }
}
