import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { environment } from './../../environments/environment';
import { SeatRequest } from '../model/seat';

const API_BASE_URL = environment.API_BASE_URL;
@Injectable({
  providedIn: 'root'
})
export class SeatService {

  constructor(private http: HttpClient) { }

  bookSeat(seatRequest: SeatRequest) {
    return this.http.post(`${API_BASE_URL}/seats/bookSeat`, seatRequest);
  }
}
