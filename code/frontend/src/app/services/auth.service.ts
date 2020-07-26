import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { JwtAuthenticationResponse, LoginRequest } from './../model/signin-request';

import { environment } from './../../environments/environment';
import { LocalStorageUtilsFunctions } from '../shared/utils';
const API_BASE_URL = environment.API_BASE_URL;
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }


  siginin(loginRequest: LoginRequest) {
    return this.http.post(`${API_BASE_URL}/auth/signin`, loginRequest).pipe(
      map(response => {
        LocalStorageUtilsFunctions.addTokenToLocalStorage(response as JwtAuthenticationResponse);
        LocalStorageUtilsFunctions.addUsernameOrEmailToLocalStorage(loginRequest.usernameOrEmail);

        return response;
      })
    );
  }


}
