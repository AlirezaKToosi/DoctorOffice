package com.doctoroffice.controller;

import com.doctoroffice.dummydata.PatientEntityDummyData;
import com.doctoroffice.entity.PatientEntity;
import com.doctoroffice.service.PatientService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {

    @BeforeEach
    void setUp() {
    }

    @Mock
    PatientService patientService;
    @InjectMocks
    PatientController patientController;

    @Test
    public void callFindAll_returnAllValidPatient() {
        //Given
        List<PatientEntity> patientEntities ;
        when(patientService.getAllPatient()).thenReturn(PatientEntityDummyData.getValidListOfPatientEntity());
        //when
        patientEntities=patientController.patientService.getAllPatient();
        //then
        assertEquals(patientEntities.size(),3);
    }
    @Test
    public void callFindById_returnValidPatient() throws Exception {
        //Given
        PatientEntity patientEntity ;
        when(patientService.getById(1)).thenReturn(PatientEntityDummyData.getValidPatientEntity(1));
        //when
        patientEntity=patientController.patientService.getById(1);
        //then
        assertEquals(patientEntity.getNationalId(),"0015478596");
    }
    @Test
    public void callFindById_returnEmptyException() throws Exception {
        //Given
         when(patientController.patientService.getById(1)).thenReturn(null);
        //when
        //then
        assertNull( patientService.getById(123));

    }
    @Test
    public void callDeleteById_DeleteValidPatient() throws Exception {
        //Given
        when(patientController.patientService.getById(1)).thenReturn(PatientEntityDummyData.getValidPatientEntity(1));
        //when
        patientController.patientService.deleteById(PatientEntityDummyData.getValidPatientEntity(1).getId());
        verify(patientController.patientService).deleteById(PatientEntityDummyData.getValidPatientEntity(1).getId());
    }
    @Test
    public void DeleteUnavailablePatientById_returnEmptyValue() throws Exception {
        //Given
        when(patientController.patientService.getById(any())).thenReturn(null);
        //When
        assertNull( patientService.getById(123));
    }
    @Test
    public void SaveOrUpdateNewPatient_returnValidPatientId() throws Exception {
        //Given
        PatientEntity samplePatient = PatientEntityDummyData.getValidPatientEntity(1);
        when(patientController.patientService.saveOrUpdate(samplePatient)).
                thenReturn(1);
        //When
        Integer patientEntityId = patientService.saveOrUpdate(samplePatient);
        //Then
        assertEquals(patientEntityId, Integer.valueOf(1));
    }
}