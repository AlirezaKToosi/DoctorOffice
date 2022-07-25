package com.doctoroffice.dummydata;

import com.doctoroffice.dto.request.RegisterPatientRequest;
import com.doctoroffice.dto.response.RegisterPatientResponse;
import com.doctoroffice.entity.PatientEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientResponseDummyData {
    public static RegisterPatientResponse getValidPatientResponse() {
    RegisterPatientResponse patientresponse = new RegisterPatientResponse("0015478596", "Mahmoud", "Hoseini",
            new Date(19850202), "09121578469", "Babol", "Male", "12354893");
        return patientresponse;
    }
    public static List<RegisterPatientResponse> getValidListOfPatientResponse() {
        List<RegisterPatientResponse> patientsresponse = new ArrayList<>();
        patientsresponse.add(new RegisterPatientResponse("0015478596", "Mahmoud", "Hoseini",
                new Date(19850202), "09121578469", "Babol", "Male",
                "12354893"));
        patientsresponse.add(new RegisterPatientResponse("0014875932", "Hamid", "soltani",
                new Date(20000215), "09112459635", "sari", "Male",
                "12354894"));
        patientsresponse.add(new RegisterPatientResponse("0213654782", "zahra", "mansoori",
                new Date(19900228), "091524863591", "mashhad", "Female",
                "12354895"));
        return patientsresponse;
    }
}
