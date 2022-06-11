package com.example.Vaccination_System.Services;

import com.example.Vaccination_System.Models.VaccinationCenter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationCenterService {

    private List<VaccinationCenter> vaccinationCenterList = new ArrayList<>();

    public List<VaccinationCenter> getVaccinationCenters(){
        return vaccinationCenterList;
    }

    public void createvaccinationCenter(VaccinationCenter vaccinationCenter){
        vaccinationCenterList.add(vaccinationCenter);
    }

}
