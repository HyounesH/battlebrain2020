package yh.sqli.hackton.seats_reservation.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Zone")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String designation;

    @OneToMany
    private List<WorkTable> workTables = new ArrayList<>();

    public Zone(String designation) {
        this.designation = designation;
    }

    public Zone() {
    }

    public Integer getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<WorkTable> getWorkTables() {
        return workTables;
    }

    public void setWorkTables(List<WorkTable> workTables) {
        this.workTables = workTables;
    }

    public void addWorkTable(WorkTable workTable) {
        this.workTables.add(workTable);
    }
}
