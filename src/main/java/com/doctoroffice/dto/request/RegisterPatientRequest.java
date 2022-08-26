package com.doctoroffice.dto.request;


import com.doctoroffice.entity.CheckNationalId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterPatientRequest {
    /**
     * nationalId
     */
    @NotBlank(message = "NationalId cannot be empty")
    @CheckNationalId
    private String nationalId;
    /**
     * firstname
     */
    @NotBlank(message = "firstname cannot be empty")
    private String firstname;
    /**
     * lastname
     */
    @NotBlank(message = "lastname cannot be empty")
    private String lastname;
    /**
     * birthday
     */

    private Date birthday;
    /**
     phoneNumber
     */
    @NotBlank(message = "phoneNumber cannot be empty")
    private String phoneNumber;
    /**
     address
     */
    @NotBlank(message = "address cannot be empty")
    private String address;
    /**
     gender
     */
    @NotBlank(message = "gender cannot be empty")
    private String gender;
    /**
     insuranceCode
     */
    private String insuranceCode;

}
