import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CookieService} from "../service/cookie.service";
import {NavigationEnd, Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {LoginService} from "../service/login.service";
import {AuthService} from "../service/auth.service";
import {ForgotService} from "../service/forgot.service";
import {CommonService} from "../service/common.service";
import {Subscription} from "rxjs";
import {Title} from "@angular/platform-browser";
import {GoogleLoginProvider, SocialAuthService, SocialUser} from "angularx-social-login";

@Component({
  selector: 'app-home-login',
  templateUrl: './home-login.component.html',
  styleUrls: ['./home-login.component.css']
})
export class HomeLoginComponent implements OnInit, OnDestroy {

  loginForm: FormGroup;
  forgotForm: FormGroup;
  messageReceived: any;
  private subscriptionName: Subscription;
  public activeLogin: boolean = false;
  public LoginFailCount: number = 0;
  public realTimeSecond: number = 0;
  public realTimeMinute: number = 2;

  // sociaUser: SocialUser;
  // userLogged: SocialUser;
  // isLogged: boolean;


  constructor(private cookieService: CookieService,
              private router: Router,
              private toastrService: ToastrService,
              private loginService: LoginService,
              private authService: AuthService,
              private forgotService: ForgotService,
              private commonService: CommonService,
              private title: Title,
              private loginGG: SocialAuthService
  ) {

    const timePrevious = Number(localStorage.getItem("time"));

    if (timePrevious != 0) {
      let realTimeInterval = setInterval(() => {
        const d = new Date();
        let hours: number = d.getHours();
        let minutes: number = d.getMinutes();
        let seconds: number = d.getSeconds();
        const timeNext = hours * 60 * 60 + minutes * 60 + seconds;
        if (timeNext - timePrevious >= 120) {
          this.activeLogin = true;
          clearInterval(realTimeInterval);
          this.realTimeSecond = 0;
          this.realTimeSecond = 0;
          localStorage.setItem("time", "0");
        }
        let realTime = ((timePrevious - timeNext) + 120)
        this.realTimeMinute = Math.floor(realTime / 60);
        this.realTimeSecond = realTime % 60;
      }, 1000)
    } else {
      this.activeLogin = true;
    }

    this.title.setTitle("Đăng Nhập");
    this.subscriptionName = this.commonService.getUpdate().subscribe(message => {
      this.messageReceived = message;
    });
  }

  ngOnInit(): void {
    this.createLoginForm();
    this.createForgotForm();
  }

  signInWithGoogle(): void {
    this.loginGG.authState.subscribe(user => {
      console.log(user);
      this.loginService.onLogin(user.email, user.id).subscribe(value => {
        this.authService.isLogin(value);
        setTimeout(value => {
          this.router.navigateByUrl('').then(() => {
            this.toastrService.success('Đăng nhập thành công');
            this.activeLogin = true;
            this.sendMessage();
          });
        }, 200);
      });
    }, error => {
      this.toastrService.error('Tên đăng nhập hoặc mật khẩu không đúng');
      console.log('error login');
      this.activeLogin = true;
    });
    this.loginGG.signIn(GoogleLoginProvider.PROVIDER_ID)
  }

  createLoginForm() {
    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
      stayLogged: new FormControl()
    })
  }

  createForgotForm() {
    this.forgotForm = new FormGroup({
      username: new FormControl('', [Validators.required])
    })
  }

  onLogin() {
    if (this.loginForm.valid && this.activeLogin) {
      const username = this.loginForm.value.username;
      const password = this.loginForm.value.password;
      if (this.loginForm.value.stayLogged) {
        this.cookieService.setCookie('stayLogged', 'true', 1);
      }
      this.loginService.onLogin(username, password).subscribe(value => {
        this.authService.isLogin(value);
      }, error => {
        // this.LoginFailCount++;
        // if (this.LoginFailCount >= 3) {
        //   const d = new Date();
        //   let hours = d.getHours();
        //   let minutes = d.getMinutes();
        //   let seconds: number = d.getSeconds();
        //   localStorage.setItem("time", String(hours * 60 * 60 + minutes * 60 + seconds));
        //   this.activeLogin = false;
        //   this.toastrService.error("Bạn nhập sai quá 3 lần hãy thử lại sau ít phút!");
        //   this.router.navigateByUrl('/home', {skipLocationChange: true}).then(() => {
        //     this.router.navigate([window.location.pathname]);
        //   });
        // } else {
        //   switch (error.error) {
        //     case "isLogin":
        //       this.toastrService.warning("Bạn đã đăng nhập rồi!");
        //       break;
        //     case "PasswordExpired":
        //       this.toastrService.warning("Mật khẩu bạn đã quá hạn vui lòng đổi mật khẩu mới!");
        //       break;
        //     default:
        //       this.toastrService.warning("Tên đăng nhập hoặc mật khẩu không chính xác!");
        //       this.toastrService.warning("Bạn nhập sai " + this.LoginFailCount + " lần.");
        //       break;
        //   }
        // }

      }, () => {
        this.router.navigateByUrl('/home').then(() => {
          this.toastrService.success("Đăng nhập thành công!")
        });
        setTimeout(() => {
          this.router.navigateByUrl('/home').then(() => {
            this.toastrService.success("Đăng nhập thành công!")
            this.sendMessage();
          });
        }, 200)
        this.router.navigateByUrl("/loading").then(() => {
        })
      });
    } else {
      this.LoginFailCount++;
      if (this.LoginFailCount >= 3) {
        const d = new Date();
        let hours = d.getHours();
        let minutes = d.getMinutes();
        let seconds: number = d.getSeconds();
        localStorage.setItem("time", String(hours * 60 * 60 + minutes * 60 + seconds));
        this.activeLogin = false;
        this.toastrService.error("Bạn nhập sai quá 3 lần hãy thử lại sau ít phút!");
        this.router.navigateByUrl('/home', {skipLocationChange: true}).then(() => {
          this.router.navigate([window.location.pathname]);
        });
      } else {
        this.toastrService.warning("Bạn nhập sai " + this.LoginFailCount + " lần.");
        this.toastrService.error("Thông tin bạn nhập không chính xác!");
      }
    }
  }

  // onForgot() {
  //   if (this.forgotForm.valid) {
  //     this.router.navigateByUrl("/loading").then(() => {
  //       //@ts-ignore
  //       $("#staticBackdropForgot").modal('hide');
  //     })
  //     this.forgotService.onForgot(this.forgotForm.value.username).subscribe(value => {
  //     }, error => {
  //       //@ts-ignore
  //       $("#staticBackdropForgot").modal('hide');
  //       this.router.navigateByUrl("/login").then(() => {
  //         this.toastrService.warning("Tên tài khoản không tồn tại!");
  //         //@ts-ignore
  //         $("#staticBackdropForgot").modal('show');
  //       })
  //     }, () => {
  //       this.router.navigateByUrl("/login").then(() => {
  //         //@ts-ignore
  //         $("#staticBackdropForgot").modal('hide');
  //         this.toastrService.success("Gửi yêu cầu thành công. Vui lòng kiểm tra email của bạn!")
  //         this.forgotForm.reset();
  //       })
  //     });
  //   } else {
  //     this.toastrService.warning("Thông tin bạn nhập chưa chính xác!")
  //   }
  // }

  sendMessage(): void {
    // send message to subscribers via observable subject
    this.commonService.sendUpdate('Đăng Nhập thành công!');
  }

  // closeForgot() {
  //   this.forgotForm.reset();
  // }

  ngOnDestroy(): void {
    this.subscriptionName.unsubscribe();
  }
}
