package com.doctoroffice.service;


import com.doctoroffice.doctorofficeexception.DoctorOfficeException;
import com.doctoroffice.dto.request.RegisterPatientRequest;
import com.doctoroffice.dto.response.RegisterPatientResponse;
import com.doctoroffice.entity.PatientEntity;
import com.doctoroffice.repository.PatientRepository;
import com.doctoroffice.service.mapper.RegisterPatientRequestToPatientEntity;
import com.doctoroffice.service.mapper.RegisterPatientResponseToPatientEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This service contains some services which is related with patient Entity
 *
 * @author Alireza
 */
@AllArgsConstructor
@NoArgsConstructor
@Service
public class PatientService {


    @Autowired
    PatientRepository patientRepository;
    RegisterPatientRequestToPatientEntity mapperRequest=new RegisterPatientRequestToPatientEntity();
    RegisterPatientResponseToPatientEntity mapperResponse=new RegisterPatientResponseToPatientEntity();


    /**
     *    getting all patient information from database
     */
    public List<RegisterPatientResponse> getAllPatient() {
        List<RegisterPatientResponse> patientsResponse = new ArrayList<RegisterPatientResponse>();
        List<PatientEntity> patients = patientRepository.findAll();
        for (int i=0;i<patients.size();i++) {
            patientsResponse.add(mapperResponse.EntityToResponse(patients.get(i)));
        }
        return patientsResponse ;
    }

    /**
     * getting a patient information by id from database
     */
    public RegisterPatientResponse getById(String NationalId) throws DoctorOfficeException {
        PatientEntity result=patientRepository.findByNationalId(NationalId)
                .orElseThrow(()-> new DoctorOfficeException("This patient id is not available"));
        return mapperResponse.EntityToResponse(result);
    }

    /**
     * saving a specific patient by using the method save()
     */
    public RegisterPatientResponse saveOrUpdate(RegisterPatientRequest request) throws DoctorOfficeException {
        PatientEntity NewPatient=mapperRequest.RequestToEntity(request);
        if (patientRepository.findByNationalId(NewPatient.getNationalId()).isPresent()) {
            PatientEntity OldPatient=patientRepository.findByNationalId(NewPatient.getNationalId()).get();
            OldPatient.setLastModifiedBy(1L);
            OldPatient.setLastModifiedDate(LocalDateTime.now());
            OldPatient.setFirstname(NewPatient.getFirstname());
            OldPatient.setLastname(NewPatient.getLastname());
            OldPatient.setAddress(NewPatient.getAddress());
            OldPatient.setBirthday(NewPatient.getBirthday());
            OldPatient.setGender(NewPatient.getGender());
            OldPatient.setInsuranceCode(NewPatient.getInsuranceCode());
            OldPatient.setNationalId(NewPatient.getNationalId());
            OldPatient.setPhoneNumber(NewPatient.getPhoneNumber());
            PatientEntity patientResponse= patientRepository.save(OldPatient);
            return (mapperResponse.EntityToResponse(patientResponse));
        }else{
            PatientEntity patientResponse= patientRepository.save(NewPatient);
            return (mapperResponse.EntityToResponse(patientResponse));
        }
    }

    /**
     * deletes a specific patient base on it's id by using the method delete()
     */
    public void deleteById(String NationalId) throws DoctorOfficeException {
        patientRepository.findByNationalId(NationalId).orElseThrow(()
                ->new DoctorOfficeException("This patient id is not available"));
        patientRepository.deleteById(patientRepository.findByNationalId(NationalId).get().getId());
    }
}
