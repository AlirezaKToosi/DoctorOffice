package com.doctoroffice.dummydata;

import com.doctoroffice.dto.request.RegisterPatientRequest;
import com.doctoroffice.entity.PatientEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class contains sample data of patient entity for test classes
 *
 * @author Alireza
 */

public class PatientRequestDummyData {
    public static RegisterPatientRequest getValidPatientRequest() {
        RegisterPatientRequest patientrequest = new RegisterPatientRequest("0015478596", "Mahmoud", "Hoseini",
                new Date(19850202), "09121578469", "Babol", "Male", "12354893");
        return patientrequest;
    }

    public static List<RegisterPatientRequest> getValidListOfRegisterPatientRequest() {
        List<RegisterPatientRequest> patientrequest = new ArrayList<>();
        patientrequest.add(new RegisterPatientRequest("0015478596", "Mahmoud", "Hoseini",
                new Date(19850202), "09121578469", "Babol", "Male",
                "12354893"));
        patientrequest.add(new RegisterPatientRequest("0014875932", "Hamid", "soltani",
                new Date(20000215), "09112459635", "sari", "Male",
                "12354894"));
        patientrequest.add(new RegisterPatientRequest("0213654782", "zahra", "mansoori",
                new Date(19900228), "091524863591", "mashhad", "Female",
                "12354895"));
        return patientrequest;
    }
}
