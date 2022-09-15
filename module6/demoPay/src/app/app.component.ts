import {Component} from '@angular/core';
import {render} from 'creditcardpayments/creditCardPayments';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demoPay';
  constructor() {
    render({
      id: "#myPaypalButtons",
      currency: "USD",
      value: "100000.00",
      onApprove: (details => {
        alert("Thanh toán thành công")
      })
    });
  }
}
