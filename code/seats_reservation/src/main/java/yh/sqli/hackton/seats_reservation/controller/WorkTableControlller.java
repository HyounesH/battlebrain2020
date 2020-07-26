package yh.sqli.hackton.seats_reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yh.sqli.hackton.seats_reservation.domain.WorkTable;
import yh.sqli.hackton.seats_reservation.payloud.response.SeatResponse;
import yh.sqli.hackton.seats_reservation.repository.WorkTableRepository;
import yh.sqli.hackton.seats_reservation.services.WorkTableService;

import java.util.List;

import static yh.sqli.hackton.seats_reservation.constant.Constants.API_BASE_URL;

@RestController
@RequestMapping(API_BASE_URL + "/worktable")
public class WorkTableControlller {

    @Autowired
    private WorkTableRepository workTableRepository;

    @Autowired
    private WorkTableService workTableService;

    @GetMapping("/all")
    public ResponseEntity<List<WorkTable>> findAll() {
        return ResponseEntity.ok(workTableRepository.findAll());
    }

    @GetMapping("/seatsByWorkTableId/{id}")
    public ResponseEntity<SeatResponse> findSeatsByWorkTableId(@PathVariable("id") Integer workTableId) {
        final WorkTable workTable = workTableRepository.getOne(workTableId);
        SeatResponse seatResponse = new SeatResponse();

        if (workTable != null) {
            seatResponse = SeatResponse.of(workTable.getSeats());
        }
        return ResponseEntity.ok(seatResponse);
    }

    @PostMapping
    public ResponseEntity<WorkTable> save(@RequestBody WorkTable workTable) {
        return ResponseEntity.ok(workTableService.save(workTable));
    }
}
