package com.doctoroffice.dto.response;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class RegisterPatientResponse {
    /**
     * nationalId
     */
    @NotBlank
    private String nationalId;
    /**
     * firstname
     */
    @NotBlank
    private String firstname;
    /**
     * lastname
     */
    @NotBlank
    private String lastname;
    /**
     * birthday
     */
    @NotBlank
    private Date birthday;
    /**
     phoneNumber
     */
    @NotBlank
    private String phoneNumber;
    /**
     address
     */
    @NotBlank
    private String address;
    /**
     gender
     */
    @NotBlank
    private String gender;
    /**
     insuranceCode
     */
    private String insuranceCode;

}
