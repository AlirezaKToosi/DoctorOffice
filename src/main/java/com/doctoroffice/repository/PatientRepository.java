package com.doctoroffice.repository;

import com.doctoroffice.entity.PatientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * This class is repository part of DoctorOffice
 *
 * @author Alireza
 */

@Repository
public interface PatientRepository extends CrudRepository<PatientEntity, Integer> {
    List<PatientEntity> findAll();
    Optional<PatientEntity> findByNationalId(String NationalId);
}
