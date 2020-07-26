package yh.sqli.hackton.seats_reservation.payloud.response;

import yh.sqli.hackton.seats_reservation.domain.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeatResponse {

    private List<Seat> rightSeats = new ArrayList<>();

    private List<Seat> leftSeats = new ArrayList<>();

    public SeatResponse(List<Seat> rightSeats, List<Seat> leftSeats) {
        this.rightSeats = rightSeats;
        this.leftSeats = leftSeats;
    }

    public SeatResponse() {
    }

    public static SeatResponse of(List<Seat> seats) {
        return new SeatResponse(getRightSeats(seats), getLeftSeats(seats));
    }

    public List<Seat> getRightSeats() {
        return rightSeats;
    }

    public void setRightSeats(List<Seat> rightSeats) {
        this.rightSeats = rightSeats;
    }

    public List<Seat> getLeftSeats() {
        return leftSeats;
    }

    public void setLeftSeats(List<Seat> leftSeats) {
        this.leftSeats = leftSeats;
    }

    private static List<Seat> getRightSeats(List<Seat> seats) {
        return seats.stream().filter(seat -> seat.isRightSide() == true)
                .collect(Collectors.toList());
    }

    private static List<Seat> getLeftSeats(List<Seat> seats) {
        return seats.stream().filter(seat -> seat.isLeftSide() == true)
                .collect(Collectors.toList());
    }
}
