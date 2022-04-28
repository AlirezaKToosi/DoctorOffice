package com.doctoroffice.entity;

import lombok.*;

import javax.persistence.*;

/**
 * This entity contains patient information
 *
 * @author Alireza
 */
@Entity
@Table(name = "TB-PATIENT")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "SQ_PATIENT", allocationSize = 1)
    private Integer id;

    @Column(name = "NATIONAL_ID", nullable = false, length = 10)
    private String nationalId;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "BIRTHDAY")
    private String birthday;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "GENDER")
    private Boolean gender;

    @Column(name = "INSURANCE_CODE")
    private String insuranceCode;

//    public PatientEntity(String nathionalid, String firstname, String lastname, String birthday, String phonenumber, String address, boolean gender, String insurance) {
//    super();
//    this.nathionalid=nathionalid;
//    this.firstname=firstname;
//    this.lastname=lastname;
//    this.birthday=birthday;
//    this.phonenumber=phonenumber;
//    this.address=address;
//    this.gender=gender;
//    this.insurance=insurance;
//    }


}
