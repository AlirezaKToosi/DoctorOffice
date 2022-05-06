package com.doctoroffice.dummydata;

import com.doctoroffice.entity.PatientEntity;

public class PatientEntityDummyData {
    public static PatientEntity getValidPatientEntity(Integer id){
        PatientEntity patientEntity=new PatientEntity(id,"0015478596","Mahmoud","Hoseini",
                "1950/05/05","09121578469","Babol",Boolean.TRUE,"12354893");
        return patientEntity;
    }
}
