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

    private int findPatientId(String NationalId){
        List<PatientEntity> patients = new ArrayList<PatientEntity>();
        patientRepository.findAll().forEach(patients::add);
        int id=-1;
        for (int i=0;i<patients.size();i++) {
            if(patients.get(i).getNationalId().equalsIgnoreCase(NationalId))id=patients.get(i).getId();
        }
        return id;
    }
    /**
     *    getting all patient information from database
     */
    public List<RegisterPatientResponse> getAllPatient() {
        List<RegisterPatientResponse> patientsResponse = new ArrayList<RegisterPatientResponse>();
        List<PatientEntity> patients = new ArrayList<PatientEntity>();
        patientRepository.findAll().forEach(patients::add);
        for (int i=0;i<patients.size();i++) {
            patientsResponse.add(mapperResponse.EntityToResponse(patients.get(i)));
        }
        return patientsResponse ;
    }

    /**
     * getting a patient information by id from database
     */
    public RegisterPatientResponse getById(String NationalId) throws DoctorOfficeException {
        PatientEntity result=patientRepository.findById(this.findPatientId(NationalId)).orElseThrow(()-> new DoctorOfficeException("This patient id is not available"));
        return mapperResponse.EntityToResponse(result);
    }

    /**
     * saving a specific patient by using the method save()
     */
    public RegisterPatientResponse saveOrUpdate(RegisterPatientRequest request) throws DoctorOfficeException {
        PatientEntity NewPatient=mapperRequest.RequestToEntity(request);
        int id=this.findPatientId(NewPatient.getNationalId());
        if (id!=-1) {
            PatientEntity OldPatient=patientRepository.findById(id).orElseThrow(()-> new DoctorOfficeException("This patient id is not available"));
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
        int id=this.findPatientId(NationalId);
        patientRepository.findById(id).orElseThrow(() ->new DoctorOfficeException("This patient id is not available"));
        patientRepository.deleteById(id);
    }
}
