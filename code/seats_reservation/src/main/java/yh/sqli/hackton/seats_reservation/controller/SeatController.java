package yh.sqli.hackton.seats_reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yh.sqli.hackton.seats_reservation.domain.Seat;
import yh.sqli.hackton.seats_reservation.payloud.request.SeatRequest;
import yh.sqli.hackton.seats_reservation.payloud.response.ApiResponse;
import yh.sqli.hackton.seats_reservation.repository.SeatRepository;
import yh.sqli.hackton.seats_reservation.services.SeatService;
import yh.sqli.hackton.seats_reservation.services.UserService;

import static yh.sqli.hackton.seats_reservation.constant.Constants.API_BASE_URL;

@RestController
@RequestMapping(API_BASE_URL + "/seats")
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatService seatService;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<Seat> save(@RequestBody Seat seat) {
        return ResponseEntity.ok(seatRepository.save(seat));
    }

    @PutMapping("/put")
    public ResponseEntity<Seat> put(Seat seat) {
        return ResponseEntity.ok(seatRepository.save(seat));
    }

    @PostMapping("/bookSeat")
    public ResponseEntity<ApiResponse> bookSeat(@RequestBody SeatRequest seatRequest) {
        final Seat seat = seatService.bookSeat(seatRequest.getId(), seatRequest.getDateFrom(), seatRequest.getDateTo());
        userService.addBookedSeatToUser(seatRequest.getLogin(), seat);
        return ResponseEntity.ok(new ApiResponse(true, "Seat Booked successfully"));
    }
}
