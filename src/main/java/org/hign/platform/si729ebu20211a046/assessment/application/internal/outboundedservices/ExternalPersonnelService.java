package org.hign.platform.si729ebu20211a046.assessment.application.internal.outboundedservices;

import org.hign.platform.si729ebu20211a046.personnel.interfaces.rest.acl.PersonnelContextFacade;
import org.springframework.stereotype.Service;

/**
 * External personnel service
 * <p>
 *     This class is responsible for providing a facade to the personnel context
 * </p>
 * @version 1.0
 * @author Samira Alvarez Araguache
 */
@Service
public class ExternalPersonnelService {

    private final PersonnelContextFacade personnelContextFacade;

    public ExternalPersonnelService(PersonnelContextFacade personnelContextFacade) {
        this.personnelContextFacade = personnelContextFacade;
    }

    public boolean existsExaminerByNationalIdentifierId(String nationalProviderIdentifier) {
        return personnelContextFacade.existsExaminerByNationalIdentifierId(nationalProviderIdentifier);
    }
}