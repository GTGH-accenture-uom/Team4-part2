package com.example.Vaccination_System.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Insured implements Serializable {
    private String afm;
    private String amka;
    private String name;
    private LocalDate date;
    private String surname;
    private String email;
    private Reservation reservation;
    @JsonIgnore
    private int numberOfChanges;

    public Insured(String afm, String amka, String name, LocalDate date, String surname, String email) {
        this.afm = afm;
        this.amka = amka;
        this.name = name;
        this.date = date;
        this.surname = surname;
        this.email = email;
        this.reservation = null;
        this.numberOfChanges = 0;
    }

    public int getNumberOfChanges() {
        return numberOfChanges;
    }

    public void setNumberOfChanges(int numberOfChanges) {
        this.numberOfChanges = numberOfChanges;
    }

    public Insured(){}

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insured insured = (Insured) o;
        return amka.equals(insured.amka);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amka);
    }
}
