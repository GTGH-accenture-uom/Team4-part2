package com.example.Vaccination_System.Controllers;

import com.example.Vaccination_System.Models.Timeslot;
import com.example.Vaccination_System.Services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeslotController {

    @Autowired
    private TimeslotService timeslotService;

    @PostMapping(path = "/createTimeslot")
    public String createTimeslot(@RequestBody Timeslot timeslot){
        timeslotService.createTimeslot(timeslot);
        return "Timeslot created";
    }

}
