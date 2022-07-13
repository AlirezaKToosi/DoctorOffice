package com.doctoroffice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Audited
@Data
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = {"createdBy", "createdDate", "lastModifiedBy"}, callSuper = false)
@ToString(of = {"createdBy", "createdDate", "lastModifiedBy"})
@SuperBuilder
@NoArgsConstructor
public class BaseAuditingEntity {

    private static final long serialVersionUID = 1L;

    @CreatedBy
    @Column(name = "CREATED_BY", length = 50, updatable = false)
    @JsonIgnore
    private Long createdBy = 0L;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @JsonIgnore
    private  LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY", length = 50)
    @JsonIgnore
    private Long lastModifiedBy;


    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    @JsonIgnore
    private  LocalDateTime lastModifiedDate = LocalDateTime.now();

}
