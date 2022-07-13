package com.doctoroffice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPatientRequest {

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
