package yh.sqli.hackton.seats_reservation.payloud.response;

import yh.sqli.hackton.seats_reservation.domain.Floor;

import java.io.Serializable;

public class FloorResponse implements Serializable {
    private Integer id;
    private String designation;
    private int zonesSize;

    public FloorResponse(Integer id, String designation, int zonesSize) {
        this.id = id;
        this.designation = designation;
        this.zonesSize = zonesSize;
    }

    public FloorResponse() {}

    public static FloorResponse of(Floor floor) {
        return  new FloorResponse(floor.getId(), floor.getDesignation(),floor.getZones().size());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getZonesSize() {
        return zonesSize;
    }

    public void setZonesSize(int zonesSize) {
        this.zonesSize = zonesSize;
    }
}
