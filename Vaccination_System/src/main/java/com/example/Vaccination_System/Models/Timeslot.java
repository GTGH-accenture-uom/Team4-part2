package com.example.Vaccination_System.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Timeslot implements Serializable {
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minutes;
    private int startMinute;
    private int endMinute;
    @JsonIgnore
    private Doctor doctor;
    private String doctorName;
    private boolean available;
    private static int id = 1;
    private int timeslotId;

    public Timeslot(int day, int month, int year, int hour, int minutes, int startMinute, int endMinute, Doctor doctor) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minutes = minutes;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
        this.doctor = doctor;
        this.available = true;
        this.doctorName = null;
        this.timeslotId = id;
    }

    public Timeslot(){
        this.timeslotId = id;
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.hour = 0;
        this.minutes = 0;
        this.startMinute = 0;
        this.endMinute = 0;
        this.doctor = null;
        this.doctorName = null;
        this.available = true;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Timeslot.id = id;
    }

    public int getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(int timeslotId) {
        this.timeslotId = timeslotId;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDate getDate(){
        return LocalDate.of(getYear(),getMonth(),getDay());
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timeslot timeslot = (Timeslot) o;
        return timeslotId == timeslot.timeslotId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeslotId);
    }

    public LocalTime getTime()
    {
        return LocalTime.of(getHour(),getMinutes());
    }
}
