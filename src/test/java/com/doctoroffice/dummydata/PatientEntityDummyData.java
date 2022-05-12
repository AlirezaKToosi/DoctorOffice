package com.doctoroffice.dummydata;

import com.doctoroffice.entity.PatientEntity;

import java.util.Date;

/**
 * This class contains sample data of patient entity for test classes
 *
 * @author Alireza
 */

public class PatientEntityDummyData {
    public static PatientEntity getValidPatientEntity(Integer id) {
        PatientEntity patientEntity = new PatientEntity(id, "0015478596", "Mahmoud", "Hoseini",
                new Date(19850202), "09121578469", "Babol", "Male", "12354893");
        return patientEntity;
    }
}
