package com.example.Vaccination_System.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

public class Reservation implements Serializable {
    private static int id = 1;
    private int reservationId;
    @JsonIgnore
    private Insured insured;
    private String insuredName;
    private Timeslot timeslot;

    //constructors
    public Reservation() {
        this.reservationId = id;
        this.insured = new Insured();
        this.timeslot = new Timeslot();
    }

    public Reservation(Insured insured, Timeslot timeslot) {
        this.reservationId = id;
        this.insured = insured;
        this.insuredName = insured.getName() + " " + insured.getSurname();
        this.timeslot = timeslot;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }


    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Reservation.id = id;
    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
        setInsuredName(insured.getName() + " " + insured.getSurname());
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    //toString method
    @Override
    public String toString() {
        return "Reservation{" + "insured=" + insuredName + ", timeslot=" + timeslot + '}';
    }

}