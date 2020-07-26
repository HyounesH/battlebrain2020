package yh.sqli.hackton.seats_reservation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yh.sqli.hackton.seats_reservation.domain.Seat;
import yh.sqli.hackton.seats_reservation.domain.WorkTable;
import yh.sqli.hackton.seats_reservation.repository.SeatRepository;
import yh.sqli.hackton.seats_reservation.repository.WorkTableRepository;
import yh.sqli.hackton.seats_reservation.services.WorkTableService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultWorkTableService implements WorkTableService {

    @Autowired
    private WorkTableRepository workTableRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public WorkTable save(WorkTable workTable) {
        List<Seat> workTableSeats = adjustWorkTableSeats(workTable.getSeats());
        workTable.setSeats(workTableSeats);
        return workTableRepository.save(workTable);
    }

    private List<Seat> adjustWorkTableSeats(List<Seat> seats) {
        List<Seat> leftSeats = seats.stream().filter(seat -> seat.isLeftSide()).collect(Collectors.toList());
        List<Seat> rightSeats = seats.stream().filter(seat -> seat.isRightSide()).collect(Collectors.toList());

        boolean rightAvailable = false;
        for (Seat seat : rightSeats) {
            rightAvailable = !rightAvailable;
            seat.setAvailable(rightAvailable);
            seat.setProhibition(!rightAvailable);
            seatRepository.save(seat);
        }
        boolean leftAvailable = true;
        for (Seat seat : leftSeats) {
            leftAvailable = !leftAvailable;
            seat.setAvailable(leftAvailable);
            seat.setProhibition(!leftAvailable);
            seatRepository.save(seat);
        }
        return seats;
    }
}
