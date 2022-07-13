package com.doctoroffice.service;


import com.doctoroffice.dto.request.RegisterPatientRequest;
import com.doctoroffice.dto.response.RegisterPatientResponse;
import com.doctoroffice.entity.PatientEntity;
import com.doctoroffice.repository.PatientRepository;
import com.doctoroffice.service.mapper.RegisterPatientRequestToPatientEntity;
import com.doctoroffice.service.mapper.RegisterPatientResponseToPatientEntity;
import fr.xebia.extras.selma.Selma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This service contains some services which is related with patient Entity
 *
 * @author Alireza
 */

@Service
public class PatientService {
    private RegisterPatientRequestToPatientEntity mapperRequest=
            Selma.builder(RegisterPatientRequestToPatientEntity.class).build();
    private RegisterPatientResponseToPatientEntity mapperResponse=
            Selma.builder(RegisterPatientResponseToPatientEntity.class).build();
    @Autowired
    PatientRepository patientRepository;
    private PatientEntity patient;

    /**
     *    getting all patient information from database
     */
    public List<PatientEntity> getAllPatient() {
        List<PatientEntity> patients = new ArrayList<PatientEntity>();
        patientRepository.findAll().forEach(patients::add);

        return patients;
    }

    /**
     * getting a patient information by id from database
     */
    public PatientEntity getById(Integer id) throws Exception {
        return patientRepository.findById(id).orElseThrow(()-> new Exception("This patient id is not available"));
    }

    /**
     * saving a specific patient by using the method save()
     */
    public RegisterPatientResponse saveOrUpdate(RegisterPatientRequest request) {
        return (mapperResponse.asRegisterPatientResponse(patientRepository.save(mapperRequest.asPatientEntity(request))));
    }
    /**
     * deletes a specific patient base on it's id by using the method delete()
     */
    public void deleteById(Integer id) throws Exception {
        patientRepository.findById(id).orElseThrow(() ->new Exception("This patient id is not available"));
        patientRepository.deleteById(id);
    }
}
