package com.example.Vaccination_System.Services;

import com.example.Vaccination_System.Models.Reservation;
import org.springframework.stereotype.Service;

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


}
