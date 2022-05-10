package com.doctoroffice.service;

import com.doctoroffice.dummydata.PatientEntityDummyData;
import com.doctoroffice.entity.PatientEntity;
import com.doctoroffice.repository.PatientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {
    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    private PatientService sut;

    @Test
    public void callFindById_returnValidPatient() {
        //Given
        when(patientRepository.findById(1)).thenReturn(Optional.of(PatientEntityDummyData.getValidPatientEntity(1)));
        //When
        PatientEntity patientEntity = sut.getById(1);
        //Then
        assertEquals(patientEntity.getNationalId(), "0015478596");
    }
}