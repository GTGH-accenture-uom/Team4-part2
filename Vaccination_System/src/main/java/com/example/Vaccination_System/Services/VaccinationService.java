package com.example.Vaccination_System.Services;


import com.example.Vaccination_System.Models.Doctor;
import com.example.Vaccination_System.Models.Insured;
import com.example.Vaccination_System.Models.Vaccination;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationService {
    private List<Vaccination> vaccinations = new ArrayList<>();

    public void createVaccination(Vaccination vaccination){
        for (Vaccination v: vaccinations) {
            if(v.equals(vaccination))
                throw new IllegalStateException("This vaccination has already been registered!");
        }
        vaccinations.add(vaccination);
    }

    public List<Vaccination> getVaccinations(){
        return vaccinations;
    }

    public List<Vaccination> getVaccinationsByDoctor(Doctor doctor){
        List<Vaccination> vaccinationList = new ArrayList<>();
        for (Vaccination v: vaccinations) {
            if (v.getDoctor().equals(doctor))
                vaccinationList.add(v);
        }
        return vaccinationList;
    }
}
