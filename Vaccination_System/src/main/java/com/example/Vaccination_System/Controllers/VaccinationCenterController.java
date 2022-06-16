package com.example.Vaccination_System.Controllers;

import com.example.Vaccination_System.Models.Timeslot;
import com.example.Vaccination_System.Models.VaccinationCenter;
import com.example.Vaccination_System.Services.TimeslotService;
import com.example.Vaccination_System.Services.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VaccinationCenterController {

    @Autowired
    private VaccinationCenterService vaccinationCenterService;
    @Autowired
    private TimeslotService timeslotService;

    @GetMapping(path = "/vaccinationcenter")
    public List<VaccinationCenter> getVaccinationCenters(){
        return vaccinationCenterService.getVaccinationCenters();
    }

    @PostMapping(path = "/vaccinationcenter")
    public String createVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter){
        vaccinationCenterService.createVaccinationCenter(vaccinationCenter);
        return "Vaccination Center created";
    }

    @PutMapping(path = "/vaccinationcenter/{vcCode}")
    public String addTimeslot(@PathVariable(value = "vcCode") String vcCode,
                              @RequestParam(name = "timeslotId") int timeslotId){
        vaccinationCenterService.addTimeslot(vcCode,timeslotService.findTimeslotById(timeslotId));
        return "Timeslot added!";
    }

    @GetMapping(path = "/reservation/vaccinationcenter/{code}/date")
    public List<Timeslot> searchByDate(@PathVariable(value = "code") String code,
                                       @RequestParam (name = "day") int day,
                                       @RequestParam (name = "month") int month,
                                       @RequestParam (name = "year") int year){
        return vaccinationCenterService.getAvailableTimeslots(code,day,month,year);
    }

    @GetMapping(path = "/reservation/vaccinationcenter/{code}/monthly")
    public List<Timeslot> searchMonthly(@PathVariable(value = "code") String code,
                                        @RequestParam (name = "month") int month){
        return vaccinationCenterService.searchMonthly(code,month);
    }

}
