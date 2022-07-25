package com.doctoroffice.service.mapper;

import com.doctoroffice.dto.request.RegisterPatientRequest;
import com.doctoroffice.entity.PatientEntity;
import fr.xebia.extras.selma.*;


@Mapper(
        withCustomFields = {
                @Field({"nationalId","nationalId"}),
                @Field({"firstname","firstname"}),
                @Field({"lastname","lastname"}),
                @Field({"birthday","birthday"}),
                @Field({"phoneNumber","phoneNumber"}),
                @Field({"address","address"}),
                @Field({"gender","gender"}),
                @Field({"insuranceCode","insuranceCode"})
        },
        withIgnoreFields = {"createdBy","createdDate","lastModifiedBy","lastModifiedDate","id"}
)
public interface RegisterPatientRequestToPatientEntity {

 // Returns a new instance of PersonDTO mapped from Person source
 RegisterPatientRequest asRegisterPatientRequest(PatientEntity source);

 // Returns a new instance of Person mapped from PersonDTO source
 PatientEntity asPatientEntity(RegisterPatientRequest source);
}

