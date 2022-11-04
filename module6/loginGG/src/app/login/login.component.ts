import { Component, OnInit } from '@angular/core';
import {GoogleLoginProvider, SocialAuthService} from "angularx-social-login";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService: SocialAuthService) { }

  ngOnInit(): void {
  }

  signInWithGoogle(): void {
    this.authService.signIn(GoogleLoginProvider.PROVIDER_ID).then(
      data =>{
        console.log(data);
      }
    );
  }
}
