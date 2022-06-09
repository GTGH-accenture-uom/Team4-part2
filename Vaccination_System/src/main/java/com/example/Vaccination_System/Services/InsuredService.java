package com.example.Vaccination_System.Services;

import com.example.Vaccination_System.Models.Insured;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsuredService {

    private List<Insured> insuredList = new ArrayList<>();
    public List<Insured> getAllInsured() {
        return insuredList;
    }

    public void createInsured(Insured insured) {
        insuredList.add(insured);
    }
}
