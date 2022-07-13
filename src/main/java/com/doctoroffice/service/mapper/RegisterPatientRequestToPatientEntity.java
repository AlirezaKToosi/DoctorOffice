package com.doctoroffice.service.mapper;

import com.doctoroffice.dto.request.RegisterPatientRequest;
import com.doctoroffice.entity.PatientEntity;
import fr.xebia.extras.selma.*;


@Mapper(
        withCustomFields = {
                @Field({"NATIONAL_ID", "nationalId"}),
                @Field({"FIRSTNAME", "firstname"}),
                @Field({"LASTNAME", "lastname"}),
                @Field({"BIRTHDAY", "birthday"}),
                @Field({"PHONE_NUMBER", "phoneNumber"}),
                @Field({"ADDRESS", "address"}),
                @Field({"GENDER", "gender"}),
                @Field({"INSURANCE_CODE", "insuranceCode"})
        },
        withIgnoreFields = "id"
)
public interface RegisterPatientRequestToPatientEntity {

 // Returns a new instance of PersonDTO mapped from Person source
 RegisterPatientRequest asRegisterPatientRequest(PatientEntity source);

 // Returns a new instance of Person mapped from PersonDTO source
 PatientEntity asPatientEntity(RegisterPatientRequest source);
}

