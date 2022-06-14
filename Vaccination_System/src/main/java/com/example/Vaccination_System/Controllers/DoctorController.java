package com.example.Vaccination_System.Controllers;

import com.example.Vaccination_System.Models.Doctor;
import com.example.Vaccination_System.Models.Timeslot;
import com.example.Vaccination_System.Services.DoctorService;

import com.example.Vaccination_System.Services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private TimeslotService timeslotService;

    @PostMapping(path = "/doctor")
    public String createDoctor(@RequestBody Doctor doctor){
        doctorService.createDoctor(doctor);
        return "Doctor " + doctor.getName() + " " + doctor.getSurname() + " created!";
    }

    @GetMapping(path = "/doctor")
    public List<Doctor> getDoctors(){
        return doctorService.getDoctors();
    }

    @PutMapping(path = "/doctor/{doctoramka}")
    public String addTimeslotToDoctor(@PathVariable(value = "doctoramka") String amka,
                                      @RequestParam(name = "timeslotId") int timeslotId){
        Timeslot timeslot = timeslotService.findTimeslotById(timeslotId);
        timeslotService.addDoctorToTimeslot(doctorService.findDoctorByAmka(amka),timeslotId);
        doctorService.addTimeslotToDoctor(amka,timeslot);
        return "Timeslot done";
    }
}
