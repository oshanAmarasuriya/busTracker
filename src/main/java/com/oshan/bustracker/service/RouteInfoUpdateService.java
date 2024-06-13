package com.oshan.bustracker.service;

import com.oshan.bustracker.model.BusSchedule;
import com.oshan.bustracker.model.Route;
import com.oshan.bustracker.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteInfoUpdateService {

    private RouteRepository routeRepo;

    @Autowired
    public RouteInfoUpdateService(RouteRepository routeRepo){
        this.routeRepo=routeRepo;
    }

    public ResponseEntity<String> saveRouteInfo(Route route){
        Route savedRoute=routeRepo.save(route);
        if(savedRoute != null){
            return new ResponseEntity<>("{\"message\": \"" + "success!" + "\"}", HttpStatus.OK);
        }
        return  new ResponseEntity<>("{\"message\": \"" + "error!" + "\"}", HttpStatus.EXPECTATION_FAILED);

    }

    public ResponseEntity<List<Route>> getRoutes(){
        return new ResponseEntity<>(routeRepo.findAll(),HttpStatus.OK);
    }

}
