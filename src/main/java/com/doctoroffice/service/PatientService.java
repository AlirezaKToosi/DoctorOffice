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

import javax.transaction.Transactional;
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
@Transactional
@Service
public class PatientService {


    @Autowired
    PatientRepository patientRepository;
    RegisterPatientRequestToPatientEntity mapperRequest=new RegisterPatientRequestToPatientEntity();
    RegisterPatientResponseToPatientEntity mapperResponse=new RegisterPatientResponseToPatientEntity();


    /**
     *    getting all patient information from database
    @return list of RegisterPatientsResponse
     */
    public List<RegisterPatientResponse> getAllPatient() {
        List<RegisterPatientResponse> patientsResponse = new ArrayList<RegisterPatientResponse>();
        List<PatientEntity> patients = patientRepository.findAll();
        patients.forEach(patientEntity -> patientsResponse.add(mapperResponse.EntityToResponse(patientEntity)));
        return patientsResponse ;
    }

    /**
     * getting a patient information by id from database
     * @return a patient with specific National id.
     * @param NationalId
     */
    public RegisterPatientResponse getByNationalId(String NationalId) {
        PatientEntity result= null;
        try {
            result = patientRepository.findByNationalId(NationalId)
                    .orElseThrow(()-> new DoctorOfficeException("This patient id is not available"));
        } catch (DoctorOfficeException e) {
            throw new RuntimeException(e);
        }
        return mapperResponse.EntityToResponse(result);
    }

    /**
     * saving a specific patient by using the method save()
     * @return a patient response which is added to database.
     * @param requestPatient
     */
    public RegisterPatientResponse saveOrUpdate(RegisterPatientRequest requestPatient) {
        PatientEntity NewPatient=mapperRequest.RequestToEntity(requestPatient);
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
     * @param NationalId
     * @throws DoctorOfficeException
     */
    public void deleteById(String NationalId) {
        try {
            PatientEntity patientEntity=patientRepository.findByNationalId(NationalId).orElseThrow(()
                    ->new DoctorOfficeException("This patient id is not available"));
            patientRepository.deleteById(patientEntity.getId());
        } catch (DoctorOfficeException e) {
            throw new RuntimeException(e);
        }

    }
}
