package com.example.Vaccination_System.Services;

import com.example.Vaccination_System.Models.Insured;
import com.example.Vaccination_System.Models.Reservation;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class ReservationService {
    private List<Reservation> reservations = new ArrayList<>();

    public void createReservation(Reservation reservation){
        for (Reservation r: reservations) {
            if(r.getInsured().equals(reservation.getInsured()))
                throw new IllegalStateException("Insured " + reservation.getInsured().getName() + " has a reservation!");
        }
        reservation.setReservationId(Reservation.getId());
        Reservation.setId(Reservation.getId() + 1);
        reservations.add(reservation);
    }

    public List<Reservation> getReservations(){
        return reservations;
    }


    public List<Reservation> getReservationsByDay() {
        List<Reservation> reservationList = new ArrayList<>();
        for (Reservation r: reservations) {
            if (r.getTimeslot().getDate().equals(LocalDate.now()))
                reservationList.add(r);
        }
        return reservationList;
    }

    public List<Reservation> getUpcomingReservations() {
        List<Reservation> reservationList = new ArrayList<>();
        for (Reservation r: reservations) {
            if (r.getTimeslot().getDate().isAfter(LocalDate.now()))
                reservationList.add(r);
        }
        return reservationList;
    }

    public void checkReservations() {
        reservations.removeIf(r -> LocalDateTime.of(r.getTimeslot().getDate(), r.getTimeslot().getTime()).isBefore(LocalDateTime.now()));
    }

    public void writeFile() {
        try{
            FileOutputStream writeData = new FileOutputStream("./Vaccination_System/src/main/java/com/example/Vaccination_System/files/ReservationData.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(reservations);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(){
        try{
            FileInputStream readData = new FileInputStream("./Vaccination_System/src/main/java/com/example/Vaccination_System/files/ReservationData.ser");
            try {
                ObjectInputStream readStream = new ObjectInputStream(readData);
                reservations = (List<Reservation>) readStream.readObject();
                readStream.close();
            }catch (EOFException eofException){
                System.out.println("Empty file!");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
