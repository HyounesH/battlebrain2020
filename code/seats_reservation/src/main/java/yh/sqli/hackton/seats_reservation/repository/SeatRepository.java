package yh.sqli.hackton.seats_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yh.sqli.hackton.seats_reservation.domain.Seat;
@Repository
public interface SeatRepository extends JpaRepository<Seat,Integer> {
}
