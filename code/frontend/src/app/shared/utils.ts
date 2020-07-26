import { JwtAuthenticationResponse } from './../model/signin-request';

export class LocalStorageUtilsFunctions {

  public static getToken(): string{
    return localStorage.getItem('token');
  }

  public static addTokenToLocalStorage(tokenResponse: JwtAuthenticationResponse){
    localStorage.setItem('token', tokenResponse.tokenType  + ' ' + tokenResponse.accessToken);
  }

  public static addUsernameOrEmailToLocalStorage(usernameOrEmail: string){
    localStorage.setItem('login', usernameOrEmail);
  }

  public static getUsernameOrEmailFromLocalStorage(): string{
    return localStorage.getItem('login');
  }

  public static removeTokenFromLocalStorage(){
    localStorage.removeItem('token');
  }
  public static removeUsernameOrEmailFromLocalStorage(){
    localStorage.removeItem('login');
  }

}
