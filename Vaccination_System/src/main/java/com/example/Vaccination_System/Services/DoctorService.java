package com.example.Vaccination_System.Services;

import com.example.Vaccination_System.Models.Doctor;
import com.example.Vaccination_System.Models.Timeslot;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    private List<Doctor> doctors = new ArrayList<>();

    public void createDoctor(Doctor doctor){
        for (Doctor d: doctors) {
            if(d.equals(doctor))
                throw new IllegalStateException("Doctor with AMKA " + doctor.getAmka() + " already exists!");
        }
        doctors.add(doctor);
    }

    public List<Doctor> getDoctors(){
        return doctors;
    }

    public Doctor findDoctorByAmka(String doctorAmka) {
        for(Doctor d: doctors){
            if(d.getAmka().equals(doctorAmka))
            {
                return d;
            }
        }
        throw new IllegalStateException("There is not doctor with this amka");
    }

    public void addTimeslotToDoctor(String amka, Timeslot timeslot) {
        findDoctorByAmka(amka).addTimeslot(timeslot);
    }

    public void writeFile() {
        try{
            FileOutputStream writeData = new FileOutputStream("./Vaccination_System/src/main/java/com/example/Vaccination_System/files/DoctorData.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(doctors);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(){
        try{
            FileInputStream readData = new FileInputStream("./Vaccination_System/src/main/java/com/example/Vaccination_System/files/DoctorData.ser");
            try {
                ObjectInputStream readStream = new ObjectInputStream(readData);
                doctors = (List<Doctor>) readStream.readObject();
                readStream.close();
            }catch (EOFException eofException){
                System.out.println("Empty file!");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
