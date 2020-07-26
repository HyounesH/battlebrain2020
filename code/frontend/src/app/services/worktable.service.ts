import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from './../../environments/environment';
const API_BASE_URL = environment.API_BASE_URL;
@Injectable({
  providedIn: 'root'
})
export class WorktableService {

  constructor(private http: HttpClient) { }

  findSeatsByWorkTableId(workTableId) {
    return this.http.get(`${API_BASE_URL}/worktable/seatsByWorkTableId/${workTableId}`);
  }

}
