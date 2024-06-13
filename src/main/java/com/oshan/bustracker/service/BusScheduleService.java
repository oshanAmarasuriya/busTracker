package com.oshan.bustracker.service;

import com.oshan.bustracker.controller.BusScheduleDto;
import com.oshan.bustracker.model.BusSchedule;
import com.oshan.bustracker.model.Route;
import com.oshan.bustracker.repository.BusScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusScheduleService {

    private BusScheduleRepository schRepo;
    @Autowired
    public BusScheduleService(BusScheduleRepository schRepo){
        this.schRepo=schRepo;
    }

    public ResponseEntity<String> saveSchedule(BusScheduleDto busScheduleDto){
        BusSchedule busSchedule = new BusSchedule();
        Route route = new Route();
        route.setRouteId(2L);
        busSchedule.setRoute(route);
        busSchedule.setArrivalTime(busScheduleDto.getArrivalTime());
        busSchedule.setDepartureTime(busScheduleDto.getDepartureTime());
        busSchedule.setVotes(busScheduleDto.getVotes());

        BusSchedule savedSchedule = schRepo.save(busSchedule);
        if(savedSchedule != null){
            return new ResponseEntity<>("{\"message\": \"" + "success!" + "\"}", HttpStatus.OK);
        }
        return  new ResponseEntity<>("{\"message\": \"" + "error!" + "\"}", HttpStatus.EXPECTATION_FAILED);
    }

    public ResponseEntity<List<BusSchedule>> getSchedules(){
        return new ResponseEntity<>(schRepo.findAll(),HttpStatus.OK);
    }



}
