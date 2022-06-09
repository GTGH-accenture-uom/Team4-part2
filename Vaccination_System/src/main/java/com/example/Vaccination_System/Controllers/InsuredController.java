package com.example.Vaccination_System.Controllers;

import com.example.Vaccination_System.Services.InsuredService;
import com.example.Vaccination_System.Models.Insured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InsuredController {

    @Autowired
    private InsuredService insuredService;

    @GetMapping(path = "/getInsured")
    public List<Insured> getAllInsured(){
        return insuredService.getAllInsured();
    }

    @PostMapping(path = "/createinsured")
    public String createInsured(@RequestBody Insured insured){
        insuredService.createInsured(insured);
        return "Insured created";
    }
}
