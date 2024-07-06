package org.hign.platform.si729ebu20211a046.assessment.interfaces.rest.transform;

import org.hign.platform.si729ebu20211a046.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.si729ebu20211a046.assessment.interfaces.rest.resources.MentalStateExamResource;

public class MentalStateExaminerResourceFromEntityAssembler {
    public static MentalStateExamResource toResourceFromEntity(MentalStateExam entity) {
        return new MentalStateExamResource(
                entity.getId(),
                entity.getPatientId(),
                entity.getExaminerNationalProviderIdentifier(),
                entity.getExamDate(),
                entity.getOrientationScore(),
                entity.getRegistrationScore(),
                entity.getAttentionAndCalculationScore(),
                entity.getRecallScore(),
                entity.getLanguageScore()
        );
    }
}

