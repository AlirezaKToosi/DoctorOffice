package com.doctoroffice.controller;

import com.doctoroffice.entity.PatientEntity;
import com.doctoroffice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//mark class as Controller
@RestController
public class PatientController {
    //Autowired the PatientService class
    @Autowired
    PatientService patientService;

    //creating a get mapping that retrieves all the patients detail from the database
    @GetMapping("/patient")
    private List<PatientEntity> getAllPatient() {
        return patientService.getAllPatient();
    }

    //creating a get mapping that returns the specific patient with it's id from database
    @GetMapping("/patient/{id}")
    private PatientEntity getPatientById(@PathVariable("id") Integer id) {
        return patientService.getById(id);
    }

    //creating post mapping that save new patient detail in the database
    @PostMapping("/patient")
    private Integer savePatient(@RequestBody PatientEntity patient) {
        return (patientService.saveOrUpdate(patient));
    }

    //creating put mapping that update the patient detail in the database
    @PutMapping("/patient")
    private void updatePatient(@RequestBody PatientEntity patient) {
        patientService.saveOrUpdate(patient);
    }

    @DeleteMapping("/patient/{id}")
    private void deleteById(@PathVariable("id") Integer id) {
        patientService.deleteById(id);
    }
}