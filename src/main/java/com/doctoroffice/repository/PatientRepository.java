package com.doctoroffice.repository;

import com.doctoroffice.entity.PatientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PatientRepository extends CrudRepository<PatientEntity,Integer> {
}
