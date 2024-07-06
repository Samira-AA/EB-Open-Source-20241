package org.hign.platform.si729ebu20211a046.personnel.infrastructure.persistance.jpa.repositories;

import org.hign.platform.si729ebu20211a046.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.si729ebu20211a046.shared.domain.model.valuobject.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for Examiner
 * <p>
 *     This repository is used to check if a NationalProviderIdentifier already exists in the database.
 * </p>
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
@Repository
public interface ExaminerRepository extends JpaRepository<Examiner, Long>{

    Optional<Examiner> findByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);
    boolean existsByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);
}
