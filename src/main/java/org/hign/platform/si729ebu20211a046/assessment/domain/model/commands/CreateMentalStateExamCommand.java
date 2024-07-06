package org.hign.platform.si729ebu20211a046.assessment.domain.model.commands;

import org.hign.platform.si729ebu20211a046.shared.domain.model.valuobject.NationalProviderIdentifier;

import java.util.Date;

/**
 * Create Mental State Exam Command
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
public record CreateMentalStateExamCommand(Long patientId, NationalProviderIdentifier examinerNationalProviderIdentifier, Date examDate, int orientationScore, int registrationScore, int attentionAndCalculationScore, int recallScore, int languageScore) {
    public CreateMentalStateExamCommand{
        if (patientId == null){
            throw new IllegalArgumentException("Patient Id cannot be null");
        }

        if (examinerNationalProviderIdentifier == null){
            throw new IllegalArgumentException("Examiner National Provider Identifier cannot be null");
        }

        if (examDate == null){
            throw new IllegalArgumentException("Exam Date cannot be null");
        }

        if (orientationScore < 0 || orientationScore > 10){
            throw new IllegalArgumentException("Orientation Score must be between 0 and 30");
        }

        if (registrationScore < 0 || registrationScore > 3){
            throw new IllegalArgumentException("Registration Score must be between 0 and 3");
        }

        if (attentionAndCalculationScore < 0 || attentionAndCalculationScore > 5){
            throw new IllegalArgumentException("Attention and Calculation Score must be between 0 and 5");
        }

        if (recallScore < 0 || recallScore > 3){
            throw new IllegalArgumentException("Recall Score must be between 0 and 3");
        }

        if (languageScore < 0 || languageScore > 9){
            throw new IllegalArgumentException("Language Score must be between 0 and 10");
        }
    }
}
