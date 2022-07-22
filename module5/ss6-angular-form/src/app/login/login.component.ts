import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @Output() submitCreate = new EventEmitter();
  loginFormReactive: FormGroup;

  constructor() {
    this.loginFormReactive = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])
    });
  }

  ngOnInit(): void {
  }

  createLogin() {
    console.log(this.loginFormReactive);
    if (this.loginFormReactive.valid) {
      this.submitCreate.emit(this.loginFormReactive.value);
    }
  }
}
