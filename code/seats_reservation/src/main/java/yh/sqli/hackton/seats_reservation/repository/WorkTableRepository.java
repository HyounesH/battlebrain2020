package yh.sqli.hackton.seats_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yh.sqli.hackton.seats_reservation.domain.WorkTable;
@Repository
public interface WorkTableRepository extends JpaRepository<WorkTable, Integer> {

    @Override
    WorkTable getOne(Integer integer);
}
