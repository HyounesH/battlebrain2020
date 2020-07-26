package yh.sqli.hackton.seats_reservation.payloud.response;

import yh.sqli.hackton.seats_reservation.domain.Zone;

import java.io.Serializable;

public class ZoneResponse implements Serializable {
    private Integer id;
    private String designation;

    private int tablesSize;

    public ZoneResponse(Integer id, String designation, int tablesSize) {
        this.id = id;
        this.designation = designation;
        this.tablesSize = tablesSize;
    }

    public ZoneResponse() {}

    public static  ZoneResponse of(Zone zone) {
        return new ZoneResponse(zone.getId(),zone.getDesignation(),zone.getWorkTables().size());
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

    public int getTablesSize() {
        return tablesSize;
    }

    public void setTablesSize(int tablesSize) {
        this.tablesSize = tablesSize;
    }
}
