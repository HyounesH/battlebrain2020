package yh.sqli.hackton.seats_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yh.sqli.hackton.seats_reservation.domain.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {

    @Override
    Zone getOne(Integer integer);
}
