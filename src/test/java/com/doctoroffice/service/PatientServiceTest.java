package com.doctoroffice.service;

import com.doctoroffice.dummydata.PatientEntityDummyData;
import com.doctoroffice.entity.PatientEntity;
import com.doctoroffice.repository.PatientRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class PatientServiceTest {
    @Before
    public void setup(){
        PatientEntity patientEntity;

    }
    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService sut;

    @Test
    void getAllPatient() {
    }

    @Test
    void callFindById_returnValidPatient() {
        //Given
        when(patientRepository.findById(1)).thenReturn(Optional.of(PatientEntityDummyData.getValidPatientEntity(1)));
        //When
        PatientEntity patientEntity = sut.getById(1);
        //Then
        assertEquals(patientEntity.getNationalId(),"0015478596");
    }
    @Test
    void callFindByIdInvalidPatient_returnNull() {
        when(patientRepository.findById(1)).thenReturn(Optional.empty());
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void deleteById() {
    }
}