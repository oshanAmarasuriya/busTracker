package com.oshan.bustracker.controller;

import java.time.LocalDateTime;

public class BusScheduleDto {
    private Long routeId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Integer votes;

    public Long getRouteId() {
        return routeId;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public Integer getVotes() {
        return votes;
    }
}
