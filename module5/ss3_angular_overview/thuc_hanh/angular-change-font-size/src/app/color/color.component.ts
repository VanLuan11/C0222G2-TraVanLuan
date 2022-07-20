import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  color1 = 0;
  color2 = 0;
  color3 = 0;
  setColor1(color1) {
    this.color1 = color1;
  }
  setColor2(color2) {
    this.color2 = color2;
  }
  setColor3(color3) {
    this.color3 = color3;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
