package com.doctoroffice.service.mapper;

import com.doctoroffice.dto.request.RegisterPatientRequest;
import com.doctoroffice.entity.PatientEntity;

public class RegisterPatientRequestToPatientEntity {

    public PatientEntity RequestToEntity(RegisterPatientRequest Req){
        PatientEntity out = null;
        if (Req != null) {
            out = new PatientEntity();
            out.setFirstname(Req.getFirstname());
            out.setLastname(Req.getLastname());
            out.setAddress(Req.getAddress());
            out.setBirthday(Req.getBirthday());
            out.setGender(Req.getGender());
            out.setInsuranceCode(Req.getInsuranceCode());
            out.setNationalId(Req.getNationalId());
            out.setPhoneNumber(Req.getPhoneNumber());
        }
        return out;
    }
    public RegisterPatientRequest EntityToRequest(PatientEntity Ent){
        RegisterPatientRequest out = null;
        if (Ent != null) {
            out = new RegisterPatientRequest();
            out.setFirstname(Ent.getFirstname());
            out.setLastname(Ent.getLastname());
            out.setAddress(Ent.getAddress());
            out.setBirthday(Ent.getBirthday());
            out.setGender(Ent.getGender());
            out.setInsuranceCode(Ent.getInsuranceCode());
            out.setNationalId(Ent.getNationalId());
            out.setPhoneNumber(Ent.getPhoneNumber());
        }
        return out;
}
}

