package com.example.Vaccination_System.Services;

import com.example.Vaccination_System.Models.Timeslot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeslotService {

        private List<Timeslot> timeslotList = new ArrayList<>();

        public void createTimeslot(Timeslot timeslot){
            timeslotList.add(timeslot);
        }

}
