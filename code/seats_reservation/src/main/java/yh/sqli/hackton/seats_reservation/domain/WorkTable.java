package yh.sqli.hackton.seats_reservation.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "WorkTable", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "reference"
        }),
})
public class WorkTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String reference;

    @OneToMany
    List<Seat> seats = new ArrayList<>();

    public WorkTable(String reference) {
        this.reference = reference;
    }

    public WorkTable() {}

    public Integer getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
