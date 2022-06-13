package com.example.Vaccination_System.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Doctor implements Serializable {
    private String amka;
    private String name;
    private String surname;
    private List<Timeslot> timeslotList = new ArrayList<>();

    //constructors
    public Doctor(){
        this.amka = null;
        this.name = null;
        this.surname = null;
    }

    public Doctor(String amka, String name, String surname) {
        this.amka = amka;
        this.name = name;
        this.surname = surname;
    }

    //getters and setters
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Timeslot> getTimeslotList() {
        return timeslotList;
    }

    public void setTimeslotList(List<Timeslot> timeslotList) {
        this.timeslotList = timeslotList;
    }

    //add timeslots to timeslotList
    public void addTimeslot(Timeslot t){
        timeslotList.add(t);
    }

    //prints vaccinations foreach doctor
    public String VaccinationPerDoctor(List<Vaccination> vaccinationList){
        String d="\n";
        d += ("Vaccinations for Doctor " + this.getName() + " " + this.getSurname() + ":");
        for(Vaccination v : vaccinationList)
        {
            if(v.getDoctor().equals(this))
            {
                d += ("\n" + v.getVaccinationDate() + " " + v.getInsured().getName() + " " + v.getInsured().getSurname());
            }
        }
        return d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(amka, doctor.amka);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amka);
    }

    //toString method
    @Override
    public String toString() {
        return "Doctor{" +
                "amka='" + amka + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

