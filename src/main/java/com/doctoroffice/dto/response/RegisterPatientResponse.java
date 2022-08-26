package com.doctoroffice.dto.response;


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
public class RegisterPatientResponse {
    /**
     * nationalId
     */
    @NotBlank
    @CheckNationalId
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
