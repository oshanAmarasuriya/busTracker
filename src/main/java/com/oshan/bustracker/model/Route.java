package com.oshan.bustracker.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;


    private Integer routeNumber;
    private String origin;
    private String destination;

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Integer getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(Integer routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
