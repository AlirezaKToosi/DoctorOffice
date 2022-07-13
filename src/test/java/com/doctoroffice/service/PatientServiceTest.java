package com.doctoroffice.service;

import com.doctoroffice.dummydata.PatientEntityDummyData;
import com.doctoroffice.entity.PatientEntity;
import com.doctoroffice.repository.PatientRepository;
import com.doctoroffice.service.mapper.RegisterPatientRequestToPatientEntity;
import com.doctoroffice.service.mapper.RegisterPatientResponseToPatientEntity;
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
    private RegisterPatientRequestToPatientEntity mapperRequest;
    private RegisterPatientResponseToPatientEntity mapperResponse;
    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    private PatientService sut;

    @Test
    public void callFindById_returnValidPatient() throws Exception {
        //Given
        when(patientRepository.findById(1)).thenReturn(Optional.of(PatientEntityDummyData.getValidPatientEntity(1)));
        //When
        PatientEntity patientEntity = sut.getById(1);
        //Then
        assertEquals(patientEntity.getNationalId(), "0015478596");
    }

    @Test(expected = Exception.class)
    public void callFindByNotValidId_returnEmptyValue() throws Exception {
        //Given
        when(patientRepository.findById(any())).thenReturn(Optional.empty());
        //When
        sut.getById(123);
    }

    @Test
    public void callFindAll_returnValidPatients() throws Exception {
        //Given
        when(patientRepository.findAll()).thenReturn(PatientEntityDummyData.getValidListOfPatientEntity());
        //When
        List<PatientEntity> patientEntity = sut.getAllPatient();
        //Then
        assertEquals(patientEntity.size(), 3);
    }

    @Test
    public void SaveOrUpdateNewPatient_returnValidPatientId() throws Exception {
        //Given
        PatientEntity samplePatient = PatientEntityDummyData.getValidPatientEntity(1);
        when(patientRepository.save(samplePatient)).
                thenReturn(samplePatient);
        //When
        Integer patientEntityId = mapperResponse.asPatientEntity(sut.saveOrUpdate(mapperRequest.asRegisterPatientRequest(samplePatient))).getId();
        //Then
        assertEquals(patientEntityId, Integer.valueOf(1));

    }

    @Test
    public void DeleteExistingPatientById_returnNothingWithoutAnyError() {
        when(patientRepository.findById(1)).thenReturn(Optional.of(PatientEntityDummyData.getValidPatientEntity(1)));
        //When
        patientRepository.deleteById(PatientEntityDummyData.getValidPatientEntity(1).getId());
        verify(patientRepository).deleteById(PatientEntityDummyData.getValidPatientEntity(1).getId());
    }

    @Test(expected = Exception.class)
    public void DeleteUnavailablePatientById_returnEmptyValue() throws Exception {
        //Given
        when(patientRepository.findById(any())).thenReturn(Optional.empty());
        //When
        sut.deleteById(PatientEntityDummyData.getValidPatientEntity(1).getId());
    }
}