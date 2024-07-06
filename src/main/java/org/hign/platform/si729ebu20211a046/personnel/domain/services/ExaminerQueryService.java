package org.hign.platform.si729ebu20211a046.personnel.domain.services;

import org.hign.platform.si729ebu20211a046.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.si729ebu20211a046.personnel.domain.model.queries.GetExaminerByNationalIdentifierId;

import java.util.Optional;

/**
 * Service to handle Examiner queries
 * <p></p>
 * This service is responsible for handling Examiner queries.
 * @version 1.0
 * @author Samira Alvarez Araguache
 */
public interface ExaminerQueryService {
    Optional<Examiner> handle(GetExaminerByNationalIdentifierId query);
}
