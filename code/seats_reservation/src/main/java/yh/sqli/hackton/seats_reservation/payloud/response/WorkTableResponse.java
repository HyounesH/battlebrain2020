package yh.sqli.hackton.seats_reservation.payloud.response;

import yh.sqli.hackton.seats_reservation.domain.WorkTable;

import java.io.Serializable;

public class WorkTableResponse implements Serializable {
    private Integer id;

    private String reference;

    private int seatSize;

    public WorkTableResponse(Integer id, String reference, int seatSize) {
        this.id = id;
        this.reference = reference;
        this.seatSize = seatSize;
    }

    public WorkTableResponse() {
    }

    public static WorkTableResponse of(WorkTable workTable) {
        return new WorkTableResponse(workTable.getId(), workTable.getReference(), workTable.getSeats().size());
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

    public int getSeatSize() {
        return seatSize;
    }

    public void setSeatSize(int seatSize) {
        this.seatSize = seatSize;
    }
}
