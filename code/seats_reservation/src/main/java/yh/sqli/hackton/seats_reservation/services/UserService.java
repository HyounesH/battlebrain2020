package yh.sqli.hackton.seats_reservation.services;

import yh.sqli.hackton.seats_reservation.domain.Seat;

public interface UserService {
    void addBookedSeatToUser(String username, Seat seat);
}
