package org.hign.platform.si729ebu20211a046.assessment.infrastructure.persistance.jpa.repositories;

import org.hign.platform.si729ebu20211a046.assessment.domain.model.aggregates.MentalStateExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for MentalStateExam
 * <p>
 *     This repository is used to check if a MentalStateExam already exists in the database.
 * </p>
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
@Repository
public interface MentalStateExamRepository extends JpaRepository<MentalStateExam, Long>{

}
