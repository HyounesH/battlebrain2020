import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpEvent, HttpHandler, HttpRequest, HttpErrorResponse} from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap} from 'rxjs/operators';
import { LocalStorageUtilsFunctions } from './../shared/utils';
import { Router } from '@angular/router';
const TOKEN_HEADER_KEY = 'Authorization';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
    constructor(private router: Router){
    }
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let authReq = req;
        console.log('interceptor');
        const token = LocalStorageUtilsFunctions.getToken();
        if (token != null) {
          authReq = req.clone(
              { headers : req.headers.set(TOKEN_HEADER_KEY, token)}
              );
        }
        return next.handle(authReq).pipe( tap(() => {},
        (err: any) => {
            if (err instanceof HttpErrorResponse) {
                if (err.status !== 401 || Number(err.status) !== 404 ) {
                    return;
                }
                this.router.navigate(['']);
         }
      }));
    }
}




