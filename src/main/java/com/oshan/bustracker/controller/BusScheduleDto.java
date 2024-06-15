package com.oshan.bustracker.controller;

import java.time.LocalDateTime;
import java.util.Date;

public class BusScheduleDto {
    private Long routeId;
    private Date departureTime;
    private Date arrivalTime;
    private Integer votes;
    private Double latitude;
    private Double longitude;

    public Long getRouteId() {
        return routeId;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public Integer getVotes() {
        return votes;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
