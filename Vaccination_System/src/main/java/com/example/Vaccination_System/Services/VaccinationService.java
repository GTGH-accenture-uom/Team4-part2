package com.example.Vaccination_System.Services;


import com.example.Vaccination_System.Models.Doctor;
import com.example.Vaccination_System.Models.Insured;
import com.example.Vaccination_System.Models.Vaccination;
import com.example.Vaccination_System.Models.VaccinationCenter;
import org.springframework.stereotype.Service;

import java.io.*;
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

    public Vaccination findVaccinationByInsured(Insured insured){
        for(Vaccination v : vaccinations){
            if(v.getInsured().equals(insured)){
                return v;
            }
        }
        return null;
    }

    public void writeFile() {
        try{
            FileOutputStream writeData = new FileOutputStream("./Vaccination_System/src/main/java/com/example/Vaccination_System/files/VaccinationData.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(vaccinations);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(){
        try{
            FileInputStream readData = new FileInputStream("./Vaccination_System/src/main/java/com/example/Vaccination_System/files/VaccinationData.ser");
            try {
                ObjectInputStream readStream = new ObjectInputStream(readData);
                vaccinations = (List<Vaccination>) readStream.readObject();
                readStream.close();
            }catch (EOFException eofException){
                System.out.println("Empty file!");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
