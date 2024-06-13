package com.oshan.bustracker.controller;
import com.oshan.bustracker.model.BusSchedule;
import com.oshan.bustracker.service.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/schedules")
public class BusScheduleController {
    private final BusScheduleService busScheduleService;

    @Autowired
    public BusScheduleController(BusScheduleService busSchService){
        this.busScheduleService = busSchService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addContract(@RequestBody BusScheduleDto busScheduleDto){

        return busScheduleService.saveSchedule(busScheduleDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusSchedule>> findAllSchedules(){
        return busScheduleService.getSchedules();
    }

}
