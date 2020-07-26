package yh.sqli.hackton.seats_reservation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yh.sqli.hackton.seats_reservation.domain.Seat;
import yh.sqli.hackton.seats_reservation.repository.SeatRepository;
import yh.sqli.hackton.seats_reservation.services.SeatService;

import java.util.Date;

@Service
public class DefaultSeatService implements SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public Seat bookSeat(Integer id, Date from, Date to) {
        Seat seat = seatRepository.getOne(id);
        seat.setAvailable(false);
        seat.setDateFrom(from);
        seat.setDateTo(to);

        return seatRepository.save(seat);
    }
}
