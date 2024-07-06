package org.hign.platform.si729ebu20211a046.personnel.interfaces.rest.transform;

import org.hign.platform.si729ebu20211a046.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.si729ebu20211a046.personnel.interfaces.rest.resources.CreateExaminerResource;

public class CreateExaminerCommandFromResourceAssembler {

        public static CreateExaminerCommand toCommandFromResource(CreateExaminerResource resource){
            return new CreateExaminerCommand(resource.firstName(), resource.lastName(), resource.nationalProviderIdentifier());
        }
}
