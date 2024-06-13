package com.oshan.bustracker.controller;

import com.oshan.bustracker.model.BusSchedule;
import com.oshan.bustracker.model.Route;
import com.oshan.bustracker.service.RouteInfoUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/routes")
public class RouteInfoUpdateController {
    private final RouteInfoUpdateService routeInfoUpdateService;

    @Autowired
    public RouteInfoUpdateController(RouteInfoUpdateService rs){
        this.routeInfoUpdateService=rs;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addRoute(@RequestBody Route route){
        return routeInfoUpdateService.saveRouteInfo(route);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Route>> findAllRoutes(){
        return routeInfoUpdateService.getRoutes();
    }

}
