package org.hign.platform.si729ebu20211a046.assessment.application.internal.commandservices;

import org.hign.platform.si729ebu20211a046.assessment.application.internal.outboundedservices.ExternalPersonnelService;
import org.hign.platform.si729ebu20211a046.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.si729ebu20211a046.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.si729ebu20211a046.assessment.domain.services.MentalStateExamCommandService;
import org.hign.platform.si729ebu20211a046.assessment.infrastructure.persistance.jpa.repositories.MentalStateExamRepository;
import org.hign.platform.si729ebu20211a046.personnel.infrastructure.persistance.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * Implementation of the MentalStateExamCommandService
 * <p>
 *     This class is used to handle the creation of a MentalStateExam.
 * </p>
 * @version 1.0
 * @autor Samira Alvarez Araguache
 */
@Service
public class MentalStateExamCommandServiceImpl implements MentalStateExamCommandService {
    private final MentalStateExamRepository mentalStateExamRepository;
    private final ExternalPersonnelService externalPersonnelService;

    public MentalStateExamCommandServiceImpl(MentalStateExamRepository mentalStateExamRepository, ExternalPersonnelService externalPersonnelService) {
        this.mentalStateExamRepository = mentalStateExamRepository;
        this.externalPersonnelService = externalPersonnelService;
    }

    /**
     *  Method to handle the creation of a MentalStateExam
     * @param command CreateMentalStateExamCommand
     * @return Optional<MentalStateExam>
     */
    @Override
    public Optional<MentalStateExam> handle(CreateMentalStateExamCommand command) {
        if(command.orientationScore() > 10 || command.orientationScore() < 0)
            throw new RuntimeException("orientationScore cannot be less than 0");
        if(command.registrationScore() > 3 || command.registrationScore() < 0)
            throw new RuntimeException("registrationScore cannot be less than 0");
        if(command.attentionAndCalculationScore() > 5 || command.attentionAndCalculationScore() < 0)
            throw new RuntimeException("attentionAndCalculationScore cannot be less than 0");
        if(command.recallScore() > 3 || command.recallScore() < 0)
            throw new RuntimeException("recallScore cannot be less than 0");
        if(command.languageScore() > 9 || command.languageScore() < 0)
            throw new RuntimeException("languageScore cannot be less than 0");
        if(command.examDate().after(new Date())){
            throw new RuntimeException("examDate cannot be in the future");

        }
        if (!externalPersonnelService.existsExaminerByNationalIdentifierId(String.valueOf(command.examinerNationalProviderIdentifier()))) {
            throw new RuntimeException("We cannot find the examiner with the provided national identifier");
        }
        var mentalStateExam = new MentalStateExam(command);
        return Optional.of(mentalStateExamRepository.save(mentalStateExam));
    }
}