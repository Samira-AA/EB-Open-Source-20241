package org.hign.platform.si729ebu20211a046.personnel.application.internal.commandservices.commandservices;

import org.hign.platform.si729ebu20211a046.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.si729ebu20211a046.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.si729ebu20211a046.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.si729ebu20211a046.personnel.infrastructure.persistance.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service for Examiner Command
 * <p>
 *     This service is used to handle the command for Examiner
 * </p>
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
@Service
public class ExaminerCommandServiceImpl implements ExaminerCommandService {

    private final ExaminerRepository examinerRepository;

    public ExaminerCommandServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    /**
     * Handle the command for Examiner
     *
     * @param command CreateExaminerCommand
     * @return Optional<Examiner>
     */
    @Override
    public Optional<Examiner> handle(CreateExaminerCommand command) {
        var examiner = new Examiner(command);

        if (examinerRepository.existsByNationalProviderIdentifier(examiner.getNationalProviderIdentifier())) {
            throw new IllegalArgumentException("National Provider Identifier already exists");
        }

        return Optional.of(examinerRepository.save(examiner));
    }
}
