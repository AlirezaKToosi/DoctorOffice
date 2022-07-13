package com.doctoroffice.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

/**
 * This entity contains patient information
 *
 * @author Alireza
 */
@Entity
@Table(name = "TB-PATIENT")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class PatientEntity extends BaseAuditingEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "SQ_PATIENT", allocationSize = 1)
    private Integer id;

    @Column(name = "NATIONAL_ID", nullable = false, length = 10, unique = true)
    private String nationalId;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "INSURANCE_CODE")
    private String insuranceCode;
}
