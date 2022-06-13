package com.example.Vaccination_System;

import com.example.Vaccination_System.Services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VaccinationSystemConfig {

    @Bean
    CommandLineRunner commandLineRunner(DoctorService doctorService, InsuredService insuredService, ReservationService reservationService,
                                        TimeslotService timeslotService, VaccinationService vaccinationService, VaccinationCenterService vaccinationCenterService){
        return args -> {
            doctorService.readFile();
            insuredService.readFile();
            reservationService.readFile();
            timeslotService.readFile();
            vaccinationService.readFile();
            vaccinationCenterService.readFile();
        };
    }
}
