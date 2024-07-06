package org.hign.platform.si729ebu20211a046.personnel.domain.services;

import org.hign.platform.si729ebu20211a046.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.si729ebu20211a046.personnel.domain.model.commands.CreateExaminerCommand;

import java.util.Optional;

/**
 * Service to handle Examiner commands
 * <p>
 *     This service is responsible for handling Examiner commands.
 * </p>
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
public interface ExaminerCommandService {

    Optional<Examiner> handle(CreateExaminerCommand command);
}
