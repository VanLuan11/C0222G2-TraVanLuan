import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {

  num1 = 0;
  num2 = 0;
  result: any;

  getCalculation(num3) {
    switch (num3) {
      case '+':
        this.result = this.num1 + this.num2;
        break;
      case '-':
        this.result = this.num1 - this.num2;
        break;
      case '*':
        this.result = this.num1 * this.num2;
        break;
      case '/':
        if (this.num2 !== 0) {
          this.result = this.num1 / this.num2;
        } else {
          this.result = 'Cannot be divided by 0!';
        }
        break;
    }
  }
}
