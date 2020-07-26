import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from './../../environments/environment';
const API_BASE_URL = environment.API_BASE_URL;

@Injectable({
  providedIn: 'root'
})
export class FloorService {

  constructor(private http: HttpClient) { }

  findAll() {
    return this.http.get(`${API_BASE_URL}/floor/all`);
  }

  findAllZonesByFloorId(floorId) {
    return this.http.get(`${API_BASE_URL}/floor/allZonesByFloorId/${floorId}`);
  }


}
