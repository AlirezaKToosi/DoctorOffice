package com.doctoroffice;

import com.doctoroffice.entity.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoctorofficeApplication  {
    @Autowired
    PatientRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DoctorofficeApplication.class, args);
    }


}
