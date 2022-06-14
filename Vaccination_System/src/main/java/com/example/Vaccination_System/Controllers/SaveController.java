package com.example.Vaccination_System.Controllers;

import com.example.Vaccination_System.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private InsuredService insuredService;
    @Autowired
    private TimeslotService timeslotService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private VaccinationService vaccinationService;
    @Autowired
    private VaccinationCenterService vaccinationCenterService;

    @PostMapping(path = "/save")
    public String saveData(){
        doctorService.writeFile();
        insuredService.writeFile();
        timeslotService.writeFile();
        reservationService.writeFile();
        vaccinationService.writeFile();
        vaccinationCenterService.writeFile();
        return "Data Saved!";
    }
}
