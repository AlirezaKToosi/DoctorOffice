package com.doctoroffice.dto;

import com.doctoroffice.entity.PatientEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class PatientIgnoreMixin {
    @JsonIgnore
    public abstract Integer getId();
    @JsonIgnore
    public abstract Integer getnationalId();
}
