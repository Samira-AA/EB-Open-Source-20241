package org.hign.platform.si729ebu20211a046.assessment.domain.services;

import org.hign.platform.si729ebu20211a046.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.si729ebu20211a046.assessment.domain.model.commands.CreateMentalStateExamCommand;

import java.util.Optional;

public interface MentalStateExamCommandService {

    Optional<MentalStateExam> handle(CreateMentalStateExamCommand command);
}
