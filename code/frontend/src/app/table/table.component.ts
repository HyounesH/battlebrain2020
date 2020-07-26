import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WorktableService } from '../services/worktable.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SeatRequest } from '../model/seat';

import { LocalStorageUtilsFunctions } from '../shared/utils';
import { SeatService } from '../services/seat.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  bookForm: FormGroup;
  seatRequest: SeatRequest;
  selectedSeat = 0;

  seats: any = {
  };
  constructor(private fb: FormBuilder,private router: Router, private activatedRoute: ActivatedRoute, private workTableService: WorktableService, private seatService: SeatService) { }

  ngOnInit(): void {
    const workTableId = this.activatedRoute.snapshot.params.id;
    this.findSeatsByWorkTableId(workTableId);
    this.buildBookForm();
  }

  onSeatSelected(seatId) {
   this.selectedSeat = seatId;
  }

  findSeatsByWorkTableId(workTableId) {
    this.workTableService.findSeatsByWorkTableId(workTableId).subscribe((response: any) => {
    this.seats = response;
    });
  }

  buildBookForm() {
    this.bookForm = this.fb.group({
      dateFrom: ['', [Validators.required]],
      dateTo: ['', [Validators.required]]
    });
  }

  bookSeatSubmit() {
   this.seatRequest = {
    id: this.selectedSeat,
    dateFrom: this.bookForm.value.dateFrom,
    dateTo: this.bookForm.value.dateTo,
    login: LocalStorageUtilsFunctions.getUsernameOrEmailFromLocalStorage()
   };
   this.seatService.bookSeat(this.seatRequest).subscribe(response => {
     this.router.navigate(['floor']);
   });
  }


}
