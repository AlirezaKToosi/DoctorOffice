package com.doctoroffice;

import com.doctoroffice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * This class is for running DoctorOffice Application
 *
 * @author Alireza
 */

@SpringBootApplication
public class DoctorOfficeApplication {
    @Autowired
    PatientRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DoctorOfficeApplication.class, args);
    }
}
