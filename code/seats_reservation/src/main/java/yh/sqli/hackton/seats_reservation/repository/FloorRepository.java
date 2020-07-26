package yh.sqli.hackton.seats_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yh.sqli.hackton.seats_reservation.domain.Floor;

import java.util.Optional;

@Repository
public interface FloorRepository extends JpaRepository<Floor,Integer> {
    @Override
    Optional<Floor> findById(Integer id);
}
