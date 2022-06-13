package com.example.Vaccination_System.Controllers;

import com.example.Vaccination_System.Models.Doctor;
import com.example.Vaccination_System.Models.Insured;
import com.example.Vaccination_System.Models.Reservation;
import com.example.Vaccination_System.Models.Timeslot;
import com.example.Vaccination_System.Services.DoctorService;
import com.example.Vaccination_System.Services.InsuredService;
import com.example.Vaccination_System.Services.ReservationService;
import com.example.Vaccination_System.Services.TimeslotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private InsuredService insuredService;
    @Autowired
    private TimeslotService timeslotService;

    @PostMapping(path = "/reservation")
    public String createReservation(@RequestParam(name = "insuredAmka") String insuredAmka,
                                    @RequestParam(name = "timeslotId") int timeslotId,
                                    @RequestParam(name = "doctorAmka") String doctorAmka){
        Doctor doctor = doctorService.findDoctorByAmka(doctorAmka);
        Insured insured = insuredService.findInsuredByAmka(insuredAmka);
        Timeslot timeslot = timeslotService.findTimeslotById(timeslotId);
        if(timeslot.getDoctor().equals(doctor)){
            Reservation reservation = new Reservation(insured,timeslot);
            reservationService.createReservation(reservation);
            insured.setReservation(reservation);
            timeslot.setAvailable(false);
            return "Reservation created!";
        }
        throw new IllegalStateException("This timeslot is not assigned to doctor " + doctor.getName() + "!");
    }

    @GetMapping(path = "/reservation")
    public List<Reservation> getReservations(){
        return reservationService.getReservations();
    }

    @GetMapping(path = "/upcomingreservation/daily")
    public List<Reservation> getReservationsByDay(){
        return reservationService.getReservationsByDay();
    }

    @GetMapping(path = "/upcomingreservation/total")
    public List<Reservation> getUpcomingReservations(){
        return reservationService.getUpcomingReservations();
    }

    @PostMapping(path = "/reservation/updatefile")
    public String updateFile(){
        reservationService.writeFile();
        return "File updated";
    }
}