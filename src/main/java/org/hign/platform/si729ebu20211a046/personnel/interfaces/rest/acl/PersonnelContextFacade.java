package org.hign.platform.si729ebu20211a046.personnel.interfaces.rest.acl;

import org.hign.platform.si729ebu20211a046.personnel.domain.model.queries.GetExaminerByNationalIdentifierId;
import org.hign.platform.si729ebu20211a046.personnel.domain.services.ExaminerQueryService;
import org.springframework.stereotype.Service;

/**
 * Personnel context facade
 * <p></p>
 * This class is responsible for providing a facade to the personnel context
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
@Service
public class PersonnelContextFacade {
    private final ExaminerQueryService examinerQueryService;

    public PersonnelContextFacade(ExaminerQueryService examinerQueryService) {
        this.examinerQueryService = examinerQueryService;
    }

    public boolean existsExaminerByNationalIdentifierId(String nationalIdentifierId) {
        var query = new GetExaminerByNationalIdentifierId(nationalIdentifierId);
        return examinerQueryService.handle(query).isPresent();
    }
}
