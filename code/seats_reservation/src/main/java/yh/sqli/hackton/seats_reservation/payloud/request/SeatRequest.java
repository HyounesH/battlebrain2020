package yh.sqli.hackton.seats_reservation.payloud.request;

import java.io.Serializable;
import java.util.Date;

public class SeatRequest implements Serializable {
    private Integer id;
    private Date dateFrom;
    private Date dateTo;
    private String login;

    public SeatRequest(Integer id, String login, Date dateFrom, Date dateTo) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.login = login;
    }

    public SeatRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
