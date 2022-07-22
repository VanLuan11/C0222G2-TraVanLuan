import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Register} from './register';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import validate = WebAssembly.validate;

@Component({
  selector: 'app-register-component',
  templateUrl: './register-component.component.html',
  styleUrls: ['./register-component.component.css']
})
export class RegisterComponentComponent implements OnInit {

  // register: Register[] = [];
  @Output() submitCreate = new EventEmitter();
  registerFormReactive: FormGroup;

  constructor() {
    this.registerFormReactive = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      pass: new FormGroup({
        password: new FormControl('', [Validators.minLength(6), Validators.required]),
        confirmPassword: new FormControl('', [Validators.minLength(6), Validators.required])
      }, this.checkConfirmPassword),
      country: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required, Validators.min(18)]),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required, Validators.pattern('^[+84][0-9]{9,10}$')]),
    });
  }

  ngOnInit(): void {
  }

  createRegister() {
    console.log(this.registerFormReactive);
    if (this.registerFormReactive.valid) {
      this.submitCreate.emit(this.registerFormReactive.value);
    }
  }

  checkConfirmPassword(pass: AbstractControl) {
    let value = pass.value;
    if (value.password !== value.confirmPassword) {
      return {'confirmPass' : true};
    }
    return null;
  }
}
