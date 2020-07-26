import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { LoginRequest } from '../model/signin-request';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  signinForm: FormGroup;
  loginData: LoginRequest;

  loginFail = false;


  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.buildSigninForm();
  }

  buildSigninForm() {
    this.signinForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }

  signin() {
    this.loginData = {
      usernameOrEmail: this.signinForm.value.username,
      password: this.signinForm.value.password
    };
    this.authService.siginin(this.loginData)
      .subscribe((response) => {
        this.router.navigate(['floor']);
      }, (error) => {
        this.loginFail = true;
      });
  }

}
