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
import com.doctoroffice.dto.request.RegisterPatientRequest;
import com.doctoroffice.dto.response.RegisterPatientResponse;

import java.util.List;

    /**
      mark class as Controller
     */

@RestController
@RequestMapping("/api")
public class PatientController {
    /**
     *Autowired the PatientService class
     */
    @Autowired
    PatientService patientService;

    /**
     creating a get mapping that retrieves all the patients detail from the database
     */
    @GetMapping("/patient")
    private ResponseEntity<?> getAllPatients(){
        List<RegisterPatientResponse> patientList=patientService.getAllPatient();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(patientList);
    }

    /**
     creating a get mapping that returns the specific patient with it's id from database
     */
    @GetMapping("/patient/{id}")
    private ResponseEntity getPatientById(@PathVariable("id") String id)  {
        RegisterPatientResponse patientEntity= null;
        try {
            patientEntity = patientService.getById(id);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(patientEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Patient with this NationalId Does not exist",HttpStatus.NOT_FOUND);
        }
    }

        /**
         creating post mapping that save new patient detail in the database
         */
    @PostMapping("/patient")
    private ResponseEntity savePatient(@RequestBody RegisterPatientRequest patient){
        try {
            patientService.saveOrUpdate(patient);
            return new ResponseEntity<>("Patient has been added to database",HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Patient with this information can not add to database",HttpStatus.NOT_FOUND);
        }
    }

        /**
          creating put mapping that update the patient detail in the database
         */
    @PutMapping("/patient")
    private ResponseEntity updatePatient(@RequestBody RegisterPatientRequest patient) {
        try {
            patientService.saveOrUpdate(patient);
            return new ResponseEntity<>("Patient has been updated",HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Patient with this information can not be updated",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/patient/{id}")
    private ResponseEntity<String> deleteById(@PathVariable("id") String id){
        try {
            patientService.deleteById(id);
            return new ResponseEntity<>("Patient with NationalId "+id+" has been deleted", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Patient with this NationalId Does not exist",HttpStatus.NOT_FOUND);
        }
    }
}