package com.doctoroffice.dummydata;

import com.doctoroffice.dto.request.RegisterPatientRequest;
import com.doctoroffice.entity.PatientEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientEntityDummyData {
    public static PatientEntity getValidPatientEntity(Integer id) {
        PatientEntity patientEntity = new PatientEntity(id, "0015478596", "Mahmoud", "Hoseini",
                new Date(19850202), "09121578469", "Babol", "Male", "12354893");
        return patientEntity;
    }
    public static List<PatientEntity> getValidListOfPatientEntity() {
        List<PatientEntity> patientEntities = new ArrayList<>();
        patientEntities.add(new PatientEntity(1,"0015478596", "Mahmoud", "Hoseini",
                new Date(19850202), "09121578469", "Babol", "Male",
                "12354893"));
        patientEntities.add(new PatientEntity(2,"0014875932", "Hamid", "soltani",
                new Date(20000215), "09112459635", "sari", "Male",
                "12354894"));
        patientEntities.add(new PatientEntity(3,"0213654782", "zahra", "mansoori",
                new Date(19900228), "091524863591", "mashhad", "Female",
                "12354896"));
        return patientEntities;
    }
}

