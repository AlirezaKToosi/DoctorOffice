package com.doctoroffice.repository;

import com.doctoroffice.entity.PatientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

/**
 * This class is repository part of DoctorOffice
 *
 * @author Alireza
 */

@Repository
@Transactional
public interface PatientRepository extends CrudRepository<PatientEntity, Integer> {
}
