package yh.sqli.hackton.seats_reservation.services;

import yh.sqli.hackton.seats_reservation.domain.Seat;

import java.util.Date;

public interface SeatService {

    Seat bookSeat(Integer id, Date from, Date to);
}
