import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FloorService } from '../services/floor.service';

@Component({
  selector: 'app-floor',
  templateUrl: './floor.component.html',
  styleUrls: ['./floor.component.css']
})
export class FloorComponent implements OnInit {

  floors: any[] = [];
  constructor(private router: Router, private floorService: FloorService) { }

  ngOnInit(): void {
    this.getAllFloors();
    console.log(this.floors);
  }

  goToZonePage(zoneId) {
    this.router.navigateByUrl('/zones/' + zoneId);
  }

  getAllFloors() {
   this.floorService.findAll().subscribe((response: any) => {
     console.log(response);
     this.floors = response;
   }, (error) => {
   console.log(error);
   });
  }
}
