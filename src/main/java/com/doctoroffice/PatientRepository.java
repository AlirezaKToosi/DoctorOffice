package com.doctoroffice;

import com.doctoroffice.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PatientRepository {
    @PersistenceContext
    EntityManager entityManager;

    public PatientEntity insert(PatientEntity patientEntity) {
        return entityManager.merge(patientEntity);
    }
}
