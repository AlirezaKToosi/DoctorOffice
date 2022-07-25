package com.doctoroffice.service;

import com.doctoroffice.dto.PatientIgnoreMixin;
import com.doctoroffice.dto.request.RegisterPatientRequest;
import com.doctoroffice.dto.response.RegisterPatientResponse;
import com.doctoroffice.dummydata.PatientEntityDummyData;
import com.doctoroffice.dummydata.PatientRequestDummyData;
import com.doctoroffice.dummydata.PatientResponseDummyData;
import com.doctoroffice.entity.PatientEntity;
import com.doctoroffice.repository.PatientRepository;
import com.doctoroffice.service.mapper.RegisterPatientRequestToPatientEntity;
import com.doctoroffice.service.mapper.RegisterPatientResponseToPatientEntity;
import lombok.RequiredArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {

    @Mock
    private RegisterPatientRequestToPatientEntity mapperRequest;
    @Mock
    private RegisterPatientResponseToPatientEntity mapperResponse;
    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService sut;

    public PatientServiceTest() {
    }

    @Test
    public void callFindById_returnValidPatient() throws Exception {

        //Given
        when(patientRepository.findAll())
                .thenReturn(PatientEntityDummyData.getValidListOfPatientEntity());
        when(patientRepository.findById(1))
                .thenReturn(Optional.of(PatientEntityDummyData.getValidListOfPatientEntity().get(0)));
        when(mapperResponse.asRegisterPatientResponse(PatientEntityDummyData.getValidListOfPatientEntity().get(0)))
                .thenReturn(PatientResponseDummyData.getValidListOfPatientResponse().get(0));
        //When
        RegisterPatientResponse patient = sut.getById("0015478596");
        //Then
        assertEquals(patient.getNationalId(), "0015478596");
    }

    @Test(expected = Exception.class)
    public void callFindByNotValidId_returnEmptyValue() throws Exception {
        //Given
        when(patientRepository.findById(any())).thenReturn(Optional.empty());
        //When
       sut.getById("0015478590");
    }

    @Test
    public void callFindAll_returnValidPatients() throws Exception {
        //Given
        when(patientRepository.findAll())
                .thenReturn(PatientEntityDummyData.getValidListOfPatientEntity());
        when(mapperResponse.asRegisterPatientResponse(PatientEntityDummyData.getValidListOfPatientEntity().get(0)))
                .thenReturn(PatientResponseDummyData.getValidListOfPatientResponse().get(0));
        when(mapperResponse.asRegisterPatientResponse(PatientEntityDummyData.getValidListOfPatientEntity().get(1)))
                .thenReturn(PatientResponseDummyData.getValidListOfPatientResponse().get(1));
        when(mapperResponse.asRegisterPatientResponse(PatientEntityDummyData.getValidListOfPatientEntity().get(2)))
                .thenReturn(PatientResponseDummyData.getValidListOfPatientResponse().get(2));
         //When
        List<RegisterPatientResponse> patients = sut.getAllPatient();
        //Then
        assertEquals(patients.size(), 3);

    }

    @Test
    public void SaveOrUpdateNewPatient_returnValidPatientId() throws Exception {
        //Given
        RegisterPatientResponse samplePatientResponse = PatientResponseDummyData.getValidPatientResponse();
        RegisterPatientRequest samplePatientRequest = PatientRequestDummyData.getValidPatientRequest();
        PatientEntity SamplePatientEntity= PatientEntityDummyData.getValidPatientEntity(1);
        when(patientRepository.findAll()).thenReturn(PatientEntityDummyData.getValidListOfPatientEntity());
        when(patientRepository.save(SamplePatientEntity)).thenReturn(SamplePatientEntity);
        when(patientRepository.findById(1)).thenReturn(Optional.of(SamplePatientEntity));
        when(mapperResponse.asRegisterPatientResponse(SamplePatientEntity)).thenReturn(samplePatientResponse);
        when(mapperRequest.asPatientEntity(samplePatientRequest)).thenReturn(SamplePatientEntity);
        //When
        String NationalId = sut.saveOrUpdate(samplePatientRequest).getNationalId();
        //Then
        assertEquals(NationalId, "0015478596");
    }

    @Test
    public void DeleteExistingPatientById_returnNothingWithoutAnyError() {

        when(patientRepository.findAll())
                .thenReturn(PatientEntityDummyData.getValidListOfPatientEntity());
        when(patientRepository.findById(1))
                .thenReturn(Optional.of(PatientEntityDummyData.getValidListOfPatientEntity().get(0)));
        when(mapperResponse.asRegisterPatientResponse(PatientEntityDummyData.getValidListOfPatientEntity().get(0)))
                .thenReturn(PatientResponseDummyData.getValidListOfPatientResponse().get(0));
        //When
        patientRepository.deleteById(PatientEntityDummyData.getValidPatientEntity(1).getId());
        verify(patientRepository).deleteById(PatientEntityDummyData.getValidPatientEntity(1).getId());


    }

    @Test(expected = Exception.class)
    public void DeleteUnavailablePatientById_returnEmptyValue() throws Exception {

        //Given
        when(patientRepository.findById(any())).thenReturn(Optional.empty());
        //When
        sut.deleteById(PatientEntityDummyData.getValidPatientEntity(1).getNationalId());


    }
}