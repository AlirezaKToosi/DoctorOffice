package com.doctoroffice.service;


import com.doctoroffice.entity.PatientEntity;
import com.doctoroffice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This service contains some services which is related with patient Entity
 *
 * @author Alireza
 */

//defining the business logic
@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    private PatientEntity patient;

    //getting all patient information from database
    public List<PatientEntity> getAllPatient() {
        List<PatientEntity> patients = new ArrayList<PatientEntity>();
        patientRepository.findAll().forEach(patients::add);

        return patients;
    }

    //getting a patient information by id from database
    public PatientEntity getById(Integer id) throws Exception {
        return patientRepository.findById(id).orElseThrow(()-> new Exception("This patient id is not available"));
    }

    //saving a specific patient by using the method save()
    public Integer saveOrUpdate(PatientEntity patient) {
        return (patientRepository.save(patient).getId());
    }

    //deletes a specific patient base on it's id by using the method delete()
    public void deleteById(Integer id) throws Exception {
        patientRepository.findById(id).orElseThrow(() ->new Exception("This patient id is not available"));
        patientRepository.deleteById(id);
    }
}
