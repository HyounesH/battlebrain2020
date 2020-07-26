import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FloorService } from '../services/floor.service';

@Component({
  selector: 'app-zones',
  templateUrl: './zones.component.html',
  styleUrls: ['./zones.component.css']
})
export class ZonesComponent implements OnInit {

  zones: any[] = [];
  constructor(private router: Router, private activatedRoute: ActivatedRoute, private floorService: FloorService) {

  }

  ngOnInit(): void {
    const floorId = this.activatedRoute.snapshot.params.id;
    this.getZonesByFloorId(floorId);
  }

  goToWorkTablesPage(zoneId) {
    this.router.navigateByUrl('/worktables/' + zoneId);
  }

  getZonesByFloorId(floorId) {
    this.floorService.findAllZonesByFloorId(floorId).subscribe((response: any) => {
      this.zones = response;
    });
  }




}
