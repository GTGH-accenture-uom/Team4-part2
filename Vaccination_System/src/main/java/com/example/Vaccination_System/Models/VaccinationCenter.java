package com.example.Vaccination_System.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VaccinationCenter implements Serializable {
    private String code;
    private String address;
    private List<Timeslot> timeslotList = new ArrayList<>();

    public VaccinationCenter(String code, String address) {
        this.code = code;
        this.address = address;
    }

    public VaccinationCenter() {
        this.code = null;
        this.address = null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Timeslot> getTimeslotList() {
        return timeslotList;
    }

    public void setTimeslotList(List<Timeslot> timeslotList) {
        this.timeslotList = timeslotList;
    }
}
