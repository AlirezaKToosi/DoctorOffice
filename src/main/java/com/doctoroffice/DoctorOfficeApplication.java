package com.doctoroffice;

import com.doctoroffice.entity.PatientEntity;
import com.doctoroffice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoctorOfficeApplication /*implements CommandLineRunner*/ {
    @Autowired
    PatientRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DoctorOfficeApplication.class, args);
    }


//    @Override
//    public void run(String... args) throws Exception {
//       // repository.insert(new PatientEntity("1234567899"));
//    }
}
