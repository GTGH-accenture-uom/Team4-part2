package com.example.Vaccination_System.Controllers;

import com.example.Vaccination_System.Models.Vaccination;
import com.example.Vaccination_System.Services.InsuredService;
import com.example.Vaccination_System.Models.Insured;
import com.example.Vaccination_System.Services.TimeslotService;
import com.example.Vaccination_System.Services.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InsuredController {

    @Autowired
    private InsuredService insuredService;

    @Autowired
    private TimeslotService timeslotService;

    @Autowired
    private VaccinationService vaccinationService;

    @GetMapping(path = "/insured")
    public List<Insured> getAllInsured() {
        return insuredService.getAllInsured();
    }

    @PostMapping(path = "/insured")
    public String createInsured(@RequestBody Insured insured) {
        insuredService.createInsured(insured);
        return "Insured created";
    }

    @PutMapping(path = "/reservation/{amka}/changereservation")
    public String changeReservation(@PathVariable(value = "amka") String amka,
                                    @RequestParam(name = "timeslotId") int id) {
        insuredService.changeReservation(insuredService.findInsuredByAmka(amka), timeslotService.findTimeslotById(id));
        return "Change Reservation done";
    }

    @GetMapping(path = "/vaccinationstatus/{amka}")
    public String getInsuredStatus(@PathVariable(value = "amka") String amka) {
        String status = "";
        Insured insured = insuredService.findInsuredByAmka(amka);
        Vaccination vaccination = vaccinationService.findVaccinationByInsured(insured);
        if (vaccination != null) {
            status += ("The insured with amka: " + amka + " is vaccinated with expiration date: " + vaccination.getExpirationDate().toString());
        } else {
            status += ("The insured with amka: " + amka + " is not vaccinated");
        }
        return status;
    }
}
