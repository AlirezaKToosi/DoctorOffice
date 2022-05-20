package com.doctoroffice;

import com.doctoroffice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class is for running DoctorOffice Application
 *
 * @author Alireza
 */

@EnableSwagger2
@SpringBootApplication
public class DoctorOfficeApplication {
    @Autowired
    PatientRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DoctorOfficeApplication.class, args);
    }
}
