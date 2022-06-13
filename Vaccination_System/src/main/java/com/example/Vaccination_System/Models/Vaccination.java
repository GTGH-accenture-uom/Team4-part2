package com.example.Vaccination_System.Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Vaccination implements Serializable {
    private Insured insured;
    private Doctor doctor;
    private LocalDate vaccinationDate;
    private LocalDate expirationDate;

    //constructors
    public Vaccination(){
        this.insured = new Insured();
        this.doctor = new Doctor();
        this.vaccinationDate = null;
        this.expirationDate = null;
    }
    public Vaccination(Insured insured, Doctor doctor, LocalDate vaccinationDate, LocalDate expirationDate) {
        this.insured = insured;
        this.doctor = doctor;
        this.vaccinationDate = vaccinationDate;
        this.expirationDate = expirationDate;
    }

    //getters and setters
    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccination that = (Vaccination) o;
        return Objects.equals(insured, that.insured) && Objects.equals(doctor, that.doctor) && Objects.equals(vaccinationDate, that.vaccinationDate) && Objects.equals(expirationDate, that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(insured, doctor, vaccinationDate, expirationDate);
    }

    //toString method
    @Override
    public String toString() {
        return "Vaccination{" +
                "insured=" + insured +
                ", doctor=" + doctor +
                ", vaccinationDate=" + vaccinationDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
