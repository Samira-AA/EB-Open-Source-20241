package org.hign.platform.si729ebu20211a046.assessment.interfaces.rest.transform;

import org.hign.platform.si729ebu20211a046.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.si729ebu20211a046.assessment.interfaces.rest.resources.CreateMentalStateExamResource;

public class CreateMentalStateExamCommandFromResourceAssembler {
    public static CreateMentalStateExamCommand toCommandFromResource(CreateMentalStateExamResource resource) {
        return new CreateMentalStateExamCommand(
                resource.patientId(),
                resource.examinerNationalProviderIdentifier(),
                resource.examDate(),
                resource.orientationScore(),
                resource.registrationScore(),
                resource.attentionAndCalculationScore(),
                resource.recallScore(),
                resource.languageScore()
        );
    }
}
