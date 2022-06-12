package com.example.Vaccination_System.Controllers;

import com.example.Vaccination_System.Models.Doctor;
import com.example.Vaccination_System.Services.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping(path = "/doctor")
    public String createDoctor(@RequestBody Doctor doctor){
        doctorService.createDoctor(doctor);
        return "Doctor " + doctor.getName() + " " + doctor.getSurname() + " created!";
    }

    @GetMapping(path = "doctor")
    public List<Doctor> getDoctors(){
        return doctorService.getDoctors();
    }

}
