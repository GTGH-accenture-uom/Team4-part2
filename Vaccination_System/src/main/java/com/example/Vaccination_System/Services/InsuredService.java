package com.example.Vaccination_System.Services;

import com.example.Vaccination_System.Models.Doctor;
import com.example.Vaccination_System.Models.Insured;
import com.example.Vaccination_System.Models.Timeslot;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class InsuredService {

    private List<Insured> insuredList = new ArrayList<>();
    public List<Insured> getAllInsured() {
        return insuredList;

    }

    public void createInsured(Insured insured) {
        for (Insured i: insuredList) {
            if(i.equals(insured))
                throw new IllegalStateException("Insured with afm "+ insured.getAfm() + " already exists!");
        }
        insuredList.add(insured);
    }

    public Insured findInsuredByAmka(String insuredAmka) {
        for(Insured i : insuredList){
            if(i.getAmka().equals(insuredAmka))
            {
                return i;
            }
        }
        throw new IllegalStateException("Insured with AMKA " + insuredAmka + " does not exist");
        }


    public void changeReservation(Insured insured, Timeslot timeslot) {

        if(!timeslot.isAvailable()){
            throw new IllegalStateException("Timeslot is not available");
        }
        if (insured.getReservation().getTimeslot().equals(timeslot)){
            throw new IllegalStateException("Same Reservation");
        }
        if (insured.getNumberOfChanges() >= 2){
            throw new IllegalStateException("You can not change anymore");
        }
        insured.getReservation().setTimeslot(timeslot);
        insured.setNumberOfChanges(insured.getNumberOfChanges()+1);
    }

    public void writeFile() {
        try{
            FileOutputStream writeData = new FileOutputStream("./Vaccination_System/src/main/java/com/example/Vaccination_System/files/InsuredData.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(insuredList);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(){
        try{
            FileInputStream readData = new FileInputStream("./Vaccination_System/src/main/java/com/example/Vaccination_System/files/InsuredData.ser");
            try {
                ObjectInputStream readStream = new ObjectInputStream(readData);
                insuredList = (List<Insured>) readStream.readObject();
                readStream.close();
            }catch (EOFException eofException){
                System.out.println("Empty file!");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
