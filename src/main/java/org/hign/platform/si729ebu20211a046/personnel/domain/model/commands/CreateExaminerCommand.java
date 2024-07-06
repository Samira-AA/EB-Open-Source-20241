package org.hign.platform.si729ebu20211a046.personnel.domain.model.commands;

public record CreateExaminerCommand(String firstName,
                                    String lastName,
                                    String nationalProviderIdentifier) {
    public CreateExaminerCommand {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name is required");
        }
        if (nationalProviderIdentifier == null || nationalProviderIdentifier.isBlank()) {
            throw new IllegalArgumentException("National Provider Identifier is required");
        }
    }
}
