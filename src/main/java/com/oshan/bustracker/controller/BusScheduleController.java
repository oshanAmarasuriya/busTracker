package com.oshan.bustracker.controller;
import com.oshan.bustracker.model.BusSchedule;
import com.oshan.bustracker.service.BusScheduleService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PatchMapping("/vote/{id}")
    public ResponseEntity<String> addVote(@PathVariable Long id, @CookieValue(value = "votedSchedules", defaultValue = "") String votedSchedules, HttpServletResponse response) {
        if (votedSchedules.contains("[" + id + "]")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User has already voted");
        }

        busScheduleService.addVote(id);

        // Update the cookie with the new vote
        votedSchedules += "[" + id + "]";
        Cookie cookie = new Cookie("votedSchedules", votedSchedules);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 60 * 2); // 2 hours
        response.addCookie(cookie);

        return ResponseEntity.ok("Vote added successfully");
    }

}
