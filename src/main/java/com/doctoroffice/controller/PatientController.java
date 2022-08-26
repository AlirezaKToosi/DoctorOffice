package com.doctoroffice.controller;

import com.doctoroffice.doctorofficeexception.DoctorOfficeException;
import com.doctoroffice.dto.request.RegisterPatientRequest;
import com.doctoroffice.dto.response.RegisterPatientResponse;
import com.doctoroffice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {
   @Autowired
    private PatientService patientService;

    /**
     creating a get mapping that retrieves all the patients detail from the database
     */
    @GetMapping("/patient")
    private ResponseEntity<List<RegisterPatientResponse>> getAllPatients(){
        List<RegisterPatientResponse> patientList=patientService.getAllPatient();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(patientList);
    }

    /**
     creating a get mapping that returns the specific patient with it's id from database
     */
    @GetMapping("/patient/{id}")
    private ResponseEntity<RegisterPatientResponse> getPatientById(@PathVariable("id") String id)  {
        RegisterPatientResponse patientEntityResponse= null;
        try {
            patientEntityResponse = patientService.getById(id);
        } catch (DoctorOfficeException e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(patientEntityResponse);
    }

        /**
         creating post mapping that save new patient detail in the database
         */
    @PostMapping("/patient")
    private ResponseEntity savePatient(@Valid @RequestBody RegisterPatientRequest patient, BindingResult bindingResult){
        try {
            if (bindingResult.hasErrors()) {
                System.out.println("error");
            }
            patientService.saveOrUpdate(patient);
            return new ResponseEntity<>("Patient has been added to database",HttpStatus.NOT_FOUND);

        } catch (DoctorOfficeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Patient with this information can not add to database",HttpStatus.NOT_FOUND);
        }
    }

        /**
          creating put mapping that update the patient detail in the database
         */
    @PutMapping("/patient")
    private ResponseEntity updatePatient(@Valid @RequestBody RegisterPatientRequest patient,BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                System.out.println("error");
            }
            patientService.saveOrUpdate(patient);
            return new ResponseEntity<>("Patient has been updated",HttpStatus.NOT_FOUND);

        } catch (DoctorOfficeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Patient with this information can not be updated",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/patient/{id}")
    private ResponseEntity<String> deleteById(@PathVariable("id") String id){
        try {
            patientService.deleteById(id);
            return new ResponseEntity<>("Patient with NationalId "+id+" has been deleted", HttpStatus.ACCEPTED);
        } catch (DoctorOfficeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Patient with this NationalId Does not exist",HttpStatus.NOT_FOUND);
        }
    }
}