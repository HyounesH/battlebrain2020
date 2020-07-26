package yh.sqli.hackton.seats_reservation.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Seat", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "reference"
        })
}
)
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reference;

    private boolean available;

    private boolean prohibition;

    private Date dateFrom;

    private Date dateTo;

    private boolean leftSide;

    private boolean rightSide;



    public Seat(String reference, boolean available, boolean prohibition, boolean leftSide, boolean rightSide, Date dateFrom, Date dateTo) {
        this.reference = reference;
        this.available = available;
        this.prohibition = prohibition;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public Seat(String reference, boolean leftSide, boolean rightSide){
        this.reference=reference;
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public Seat() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isProhibition() {
        return prohibition;
    }

    public void setProhibition(boolean prohibition) {
        this.prohibition = prohibition;
    }

    public boolean isLeftSide() {
        return leftSide;
    }

    public void setLeftSide(boolean leftSide) {
        this.leftSide = leftSide;
    }

    public boolean isRightSide() {
        return rightSide;
    }

    public void setRightSide(boolean rightSide) {
        this.rightSide = rightSide;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
