package com.doctoroffice.service.mapper;


import com.doctoroffice.dto.request.RegisterPatientRequest;
import com.doctoroffice.dto.response.RegisterPatientResponse;
import com.doctoroffice.entity.PatientEntity;

public class RegisterPatientResponseToPatientEntity{

    public PatientEntity ResponseToEntity(RegisterPatientResponse Res){
        PatientEntity out = null;
        if (Res != null) {
            out = new PatientEntity();
            out.setFirstname(Res.getFirstname());
            out.setLastname(Res.getLastname());
            out.setAddress(Res.getAddress());
            out.setBirthday(Res.getBirthday());
            out.setGender(Res.getGender());
            out.setInsuranceCode(Res.getInsuranceCode());
            out.setNationalId(Res.getNationalId());
            out.setPhoneNumber(Res.getPhoneNumber());
        }
        return out;
    }
    public RegisterPatientResponse EntityToResponse(PatientEntity Ent){
        RegisterPatientResponse out = null;
        if (Ent != null) {
            out = new RegisterPatientResponse();
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
