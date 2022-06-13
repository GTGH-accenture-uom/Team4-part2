package com.example.Vaccination_System.Services;

import com.example.Vaccination_System.Models.Doctor;
import com.example.Vaccination_System.Models.Reservation;
import com.example.Vaccination_System.Models.Timeslot;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeslotService {

        private List<Timeslot> timeslotList = new ArrayList<>();

        public void createTimeslot(Timeslot timeslot){
            timeslot.setTimeslotId(Timeslot.getId());
            Timeslot.setId(Timeslot.getId()+1);
            timeslotList.add(timeslot);
        }

        public Timeslot findTimeslotById(int id){
            for(Timeslot t: timeslotList){
                if(t.getTimeslotId()==id)
                {
                    return t;
                }
            }
            throw new IllegalStateException("Timeslot does not exist");
        }

        public void addDoctorToTimeslot(Doctor doctor,int id){
            Timeslot timeslot = findTimeslotById(id);
            if(timeslot.getDoctor() != null){
                throw new IllegalStateException("Doctor is not available");
            }
            for (Timeslot t : timeslotList){
                if(t.getDoctor() != null){
                    if ((t.getDoctor().equals(doctor)) && LocalDateTime.of(t.getDate(),t.getTime()).equals(LocalDateTime.of(timeslot.getDate(),timeslot.getTime()))){
                        if (t.getTimeslotId() != id){
                            throw new IllegalStateException("Doctor is not available");
                        } else if (t.getTimeslotId()==id) {
                            throw new IllegalStateException("This timeslot already exists");
                        }
                    }
                }
            }
            timeslot.setDoctor(doctor);
        }

    public List<Timeslot> getAllTimeslots() {
            return timeslotList;
    }

    public void writeFile() {
        try{
            FileOutputStream writeData = new FileOutputStream("./Vaccination_System/src/main/java/com/example/Vaccination_System/files/TimeslotData.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(timeslotList);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(){
        try{
            FileInputStream readData = new FileInputStream("./Vaccination_System/src/main/java/com/example/Vaccination_System/files/TimeslotData.ser");
            try {
                ObjectInputStream readStream = new ObjectInputStream(readData);
                timeslotList = (List<Timeslot>) readStream.readObject();
                readStream.close();
            }catch (EOFException eofException){
                System.out.println("Empty file!");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
