package com.example.Vaccination_System.Services;

import com.example.Vaccination_System.Models.Doctor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    private List<Doctor> doctors = new ArrayList<>();

    public void createDoctor(Doctor doctor){
        for (Doctor d: doctors) {
            if(d.getAmka().equals(doctor.getAmka()))
                throw new IllegalStateException("Doctor with AMKA " + doctor.getAmka() + " already exists!");
        }
        doctors.add(doctor);
    }

    public List<Doctor> getDoctors(){
        return doctors;
    }

    public Doctor findDoctorByAmka(String doctorAmka) {
    }
}
