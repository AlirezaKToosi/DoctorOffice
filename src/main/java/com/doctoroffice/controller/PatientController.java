package com.doctoroffice.controller;

import com.doctoroffice.dto.PatientIgnoreMixin;
import com.doctoroffice.entity.PatientEntity;
import com.doctoroffice.service.PatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//mark class as Controller
@RestController
//@RequestMapping("/api")
public class PatientController {
    //Autowired the PatientService class
    @Autowired
    PatientService patientService;

    //creating a get mapping that retrieves all the patients detail from the database
    @GetMapping("/patient")
    private ResponseEntity<?> getAllPatients() throws JsonProcessingException {
        List<PatientEntity> patientList=patientService.getAllPatient();
        ObjectMapper mapper=new ObjectMapper();
        mapper.addMixIn(PatientEntity.class, PatientIgnoreMixin.class);
        String jsonString= mapper.writeValueAsString(patientList);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(jsonString);
    }

    //creating a get mapping that returns the specific patient with it's id from database
    @GetMapping("/patient/{id}")
    private ResponseEntity getPatientById(@PathVariable("id") Integer id) throws Exception {
        PatientEntity patientEntity=patientService.getById(id);
        ObjectMapper mapper=new ObjectMapper();
        mapper.addMixIn(PatientEntity.class,PatientIgnoreMixin.class);
        String JsonString=mapper.writeValueAsString(patientEntity);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(JsonString);
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
    private ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        try {
            patientService.deleteById(id);
            return new ResponseEntity<>("Patient with id"+id+"has been deleted", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Patient with this id is not exist",HttpStatus.NOT_FOUND);
        }
    }
}