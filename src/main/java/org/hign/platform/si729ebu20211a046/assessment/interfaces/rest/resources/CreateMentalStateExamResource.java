package org.hign.platform.si729ebu20211a046.assessment.interfaces.rest.resources;

import org.hign.platform.si729ebu20211a046.shared.domain.model.valuobject.NationalProviderIdentifier;

import java.util.Date;

/**
 * CreateMentalStateExamResource
 * @param patientId
 * @param examinerNationalProviderIdentifier
 * @param examDate
 * @param orientationScore
 * @param registrationScore
 * @param attentionAndCalculationScore
 * @param recallScore
 * @param languageScore
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
public record CreateMentalStateExamResource(Long patientId, NationalProviderIdentifier examinerNationalProviderIdentifier, Date examDate, int orientationScore, int registrationScore, int attentionAndCalculationScore, int recallScore, int languageScore) {
}