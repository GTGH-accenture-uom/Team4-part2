package com.example.Vaccination_System.Controllers;

import com.example.Vaccination_System.Models.VaccinationCenter;
import com.example.Vaccination_System.Services.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VaccinationCenterController {

    @Autowired
    private VaccinationCenterService vaccinationCenterService;

    @GetMapping(path = "/createvaccinationcenter")
    public List<VaccinationCenter> getVaccinationCenters(){
        return vaccinationCenterService.getVaccinationCenters();
    }

    @PostMapping(path = "/createVaccinationCenter")
    public String createvaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter){
        vaccinationCenterService.createvaccinationCenter(vaccinationCenter);
        return "Vaccination Center created";
    }
}
