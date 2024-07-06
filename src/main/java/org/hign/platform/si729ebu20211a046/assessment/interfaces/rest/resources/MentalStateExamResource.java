package org.hign.platform.si729ebu20211a046.assessment.interfaces.rest.resources;

import org.hign.platform.si729ebu20211a046.shared.domain.model.valuobject.NationalProviderIdentifier;

import java.util.Date;

public record MentalStateExamResource(Long id, Long patientId, NationalProviderIdentifier examinerNationalProviderIdentifier, Date examDate, int orientationScore, int registrationScore, int attentionAndCalculationScore, int recallScore, int languageScore) {
}
