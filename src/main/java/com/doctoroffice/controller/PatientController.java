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
@RequestMapping("/api/patient")
public class PatientController {
   @Autowired
    private PatientService patientService;

    @GetMapping("")
    private ResponseEntity<List<RegisterPatientResponse>> getAllPatients(){
        List<RegisterPatientResponse> patientList=patientService.getAllPatient();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(patientList);
    }

    @GetMapping("/{NationalId}")
    private ResponseEntity<RegisterPatientResponse> getPatientById(@PathVariable("NationalId") String id)  {
        RegisterPatientResponse patientEntityResponse= null;
        patientEntityResponse = patientService.getByNationalId(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(patientEntityResponse);
    }

    @PostMapping("")
    private ResponseEntity savePatient(@Valid @RequestBody RegisterPatientRequest patient, BindingResult bindingResult){
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("Error in parameters, Patient with this information can not add to database",HttpStatus.NOT_FOUND);
            }
            patientService.saveOrUpdate(patient);
            return new ResponseEntity<>("Patient has been added to database",HttpStatus.NOT_FOUND);
    }

    @PutMapping("")
    private ResponseEntity updatePatient(@Valid @RequestBody RegisterPatientRequest patient,BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("Error in parameters, Patient with this information can not add to database",HttpStatus.NOT_FOUND);
            }
            patientService.saveOrUpdate(patient);
            return new ResponseEntity<>("Patient has been updated",HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{NationalId}")
    private ResponseEntity<String> deleteById(@PathVariable("NationalId") String id){
            patientService.deleteById(id);
            return new ResponseEntity<>("Patient with NationalId "+id+" has been deleted", HttpStatus.ACCEPTED);
        }
}