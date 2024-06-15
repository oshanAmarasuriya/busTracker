package com.oshan.bustracker.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name="routeId")
    private Route route;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(columnDefinition = "DATETIME(0)")
    private Date departureTime;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(columnDefinition = "DATETIME(0)")
    private Date arrivalTime;

    private Integer votes;
    private Double lastKnownLatitude;
    private Double lastKnownLongitude;

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Double getLastKnownLatitude() {
        return lastKnownLatitude;
    }

    public void setLastKnownLatitude(Double lastKnownLatitude) {
        this.lastKnownLatitude = lastKnownLatitude;
    }

    public Double getLastKnownLongitude() {
        return lastKnownLongitude;
    }

    public void setLastKnownLongitude(Double lastKnownLongitude) {
        this.lastKnownLongitude = lastKnownLongitude;
    }
}
