package com.example.Vaccination_System.Services;

import com.example.Vaccination_System.Models.Timeslot;
import com.example.Vaccination_System.Models.Vaccination;
import com.example.Vaccination_System.Models.VaccinationCenter;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class VaccinationCenterService {

    private List<VaccinationCenter> vaccinationCenterList = new ArrayList<>();

    public List<VaccinationCenter> getVaccinationCenters(){
        return vaccinationCenterList;
    }

    public void createVaccinationCenter(VaccinationCenter vaccinationCenter){
        for (VaccinationCenter vc: vaccinationCenterList) {
            if(vc.getCode().equals(vaccinationCenter.getCode()))
                throw new IllegalStateException("A Vaccination Center with code " + vc.getCode() + " already exists!");
        }
        vaccinationCenterList.add(vaccinationCenter);
    }

    public void addTimeslot(String vcCode, Timeslot timeslot){
        for (VaccinationCenter vc: vaccinationCenterList) {
            if(Objects.equals(vc.getCode(), vcCode))
                vc.addTimeslot(timeslot);
        }
    }

    public VaccinationCenter findVaccinationCenterByCode(String code){
        for (VaccinationCenter vc : vaccinationCenterList) {

            if (vc.getCode().equals(code)) {
                return vc;
            }
        }
            throw new IllegalStateException("Vaccination Center with code " + code + " does not exist");
    }

    public List<Timeslot> getAvailableTimeslots(String code, int day, int month, int year) {
        List<Timeslot> timeslotList = new ArrayList<>();
        for(Timeslot t : findVaccinationCenterByCode(code).getTimeslotList()){
            if(t.isAvailable() && t.getDate().equals(LocalDate.of(year,month,day))){
                timeslotList.add(t);
            }
        }
        return timeslotList;
    }

    public List<Timeslot> searchMonthly(String code, int month) {
        List<Timeslot> timeslotList = new ArrayList<>();
        for(Timeslot t : findVaccinationCenterByCode(code).getTimeslotList()){
            if(t.isAvailable() && t.getDate().isAfter(LocalDate.now()) && t.getMonth() == month){
                timeslotList.add(t);
            }
        }
        return timeslotList;
    }

    public void writeFile() {
        try{
            FileOutputStream writeData = new FileOutputStream("./Vaccination_System/src/main/java/com/example/Vaccination_System/files/VaccinationCenterData.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(vaccinationCenterList);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(){
        try{
            FileInputStream readData = new FileInputStream("./Vaccination_System/src/main/java/com/example/Vaccination_System/files/VaccinationCenterData.ser");
            try {
                ObjectInputStream readStream = new ObjectInputStream(readData);
                vaccinationCenterList = (List<VaccinationCenter>) readStream.readObject();
                readStream.close();
            }catch (EOFException eofException){
                System.out.println("Empty file!");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
