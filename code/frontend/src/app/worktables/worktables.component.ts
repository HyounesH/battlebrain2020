import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ZoneService } from '../services/zone.service';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-worktables',
  templateUrl: './worktables.component.html',
  styleUrls: ['./worktables.component.css']
})
export class WorktablesComponent implements OnInit {

  workTables: any[] = [
  ];
  constructor(private router: Router, private activatedRoute: ActivatedRoute, private zoneService: ZoneService ) { }

  ngOnInit(): void {
    const zoneId = this.activatedRoute.snapshot.params.id;
    this.findAllworkTablesByZoneId(zoneId);
  }

  goToTablePage(tableId){
    this.router.navigateByUrl('/table/' + tableId);
  }

  findAllworkTablesByZoneId(zoneId) {
    this.zoneService.findAllworkTablesByZoneId(zoneId).subscribe((response: any) => {
      this.workTables = response;
    });
  }

}
