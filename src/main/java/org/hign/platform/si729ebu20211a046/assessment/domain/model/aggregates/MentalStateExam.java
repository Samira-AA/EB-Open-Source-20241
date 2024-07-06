package org.hign.platform.si729ebu20211a046.assessment.domain.model.aggregates;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hign.platform.si729ebu20211a046.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.si729ebu20211a046.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.hign.platform.si729ebu20211a046.shared.domain.model.valuobject.NationalProviderIdentifier;

import java.util.Date;

/**
 * MentalStateExam aggregate root
 * <p>
 *     This class represents a MentalStateExam aggregate root.
 * </p>
 * @author Samira Alvarez
 * @version 1.0
 */
@Entity
public class MentalStateExam extends AuditableAbstractAggregateRoot<MentalStateExam> {

    @Id
    @Getter
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    @Getter
    @NotBlank
    @Column(nullable = false)
    private Long patientId;

    @Getter
    @NotBlank
    @Column(nullable = false, unique = true)
    @Embedded
    private NationalProviderIdentifier examinerNationalProviderIdentifier;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private Date examDate;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private Integer orientationScore;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private Integer registrationScore;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private Integer attentionAndCalculationScore;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private Integer recallScore;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private Integer languageScore;

    public MentalStateExam(){

    }

    public MentalStateExam(Long patientId, NationalProviderIdentifier examinerNationalProviderIdentifier, Date examDate, Integer orientationScore, Integer registrationScore, Integer attentionAndCalculationScore, Integer recallScore, Integer languageScore) {
        this.patientId = patientId;
        this.examinerNationalProviderIdentifier = examinerNationalProviderIdentifier;
        this.examDate = examDate;
        this.orientationScore = orientationScore;
        this.registrationScore = registrationScore;
        this.attentionAndCalculationScore = attentionAndCalculationScore;
        this.recallScore = recallScore;
        this.languageScore = languageScore;
    }

    public MentalStateExam(CreateMentalStateExamCommand command) {
        this.patientId = command.patientId();
        this.examinerNationalProviderIdentifier = command.examinerNationalProviderIdentifier();
        this.examDate = command.examDate();
        this.orientationScore = command.orientationScore();
        this.registrationScore = command.registrationScore();
        this.attentionAndCalculationScore = command.attentionAndCalculationScore();
        this.recallScore = command.recallScore();
        this.languageScore = command.languageScore();
    }

}
