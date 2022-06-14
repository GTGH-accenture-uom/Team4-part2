package com.example.Vaccination_System.Controllers;

import com.example.Vaccination_System.Models.Doctor;
import com.example.Vaccination_System.Models.Insured;
import com.example.Vaccination_System.Models.Timeslot;
import com.example.Vaccination_System.Models.Vaccination;
import com.example.Vaccination_System.Services.DoctorService;
import com.example.Vaccination_System.Services.InsuredService;
import com.example.Vaccination_System.Services.TimeslotService;
import com.example.Vaccination_System.Services.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VaccinationController {
    @Autowired
    private VaccinationService vaccinationService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private InsuredService insuredService;
    @Autowired
    private TimeslotService timeslotService;

    @PostMapping(path = "/vaccination/{doctorAmka}")
    public String createVaccination(@PathVariable(value = "doctorAmka") String doctorAmka,
                                    @RequestParam(name = "timeslotId") int timeslotId,
                                    @RequestParam(name = "insuredAmka") String insuredAmka,
                                    @RequestParam(name = "duration") int duration){
        Doctor doctor = doctorService.findDoctorByAmka(doctorAmka);
        Insured insured = insuredService.findInsuredByAmka(insuredAmka);
        Timeslot timeslot = timeslotService.findTimeslotById(timeslotId);
        vaccinationService.createVaccination(new Vaccination(insured,doctor,timeslot.getDate(),
                LocalDate.of(timeslot.getYear()+duration,timeslot.getMonth(),timeslot.getDay())));
        return "Vaccination created!";
    }

    @GetMapping(path = "/vaccination")
    public List<Vaccination> getVaccinations(){
        return vaccinationService.getVaccinations();
    }

}
