package org.hign.platform.si729ebu20211a046.personnel.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hign.platform.si729ebu20211a046.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.si729ebu20211a046.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.hign.platform.si729ebu20211a046.shared.domain.model.valuobject.NationalProviderIdentifier;

import java.util.UUID;

/**
 * Examiner entity
 * <p>
 *     This class represents an examiner entity.
 * </p>
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
@Entity
public class Examiner extends AuditableAbstractAggregateRoot<Examiner> {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private String firstName;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private String lastName;

    @Getter
    @Embedded
    @NotBlank
    @Column(nullable = false)
    private NationalProviderIdentifier nationalProviderIdentifier;

    public Examiner(){

    }

    public Examiner(String firstName, String lastName, NationalProviderIdentifier nationalProviderIdentifier){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalProviderIdentifier = nationalProviderIdentifier;
    }

    public Examiner(CreateExaminerCommand command){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalProviderIdentifier = nationalProviderIdentifier;
    }



}
