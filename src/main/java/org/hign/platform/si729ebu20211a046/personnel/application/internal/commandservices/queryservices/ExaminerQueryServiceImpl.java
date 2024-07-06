package org.hign.platform.si729ebu20211a046.personnel.application.internal.commandservices.queryservices;

import org.hign.platform.si729ebu20211a046.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.si729ebu20211a046.personnel.domain.model.queries.GetExaminerByNationalIdentifierId;
import org.hign.platform.si729ebu20211a046.personnel.domain.services.ExaminerQueryService;
import org.hign.platform.si729ebu20211a046.personnel.infrastructure.persistance.jpa.repositories.ExaminerRepository;
import org.hign.platform.si729ebu20211a046.shared.domain.model.valuobject.NationalProviderIdentifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 *     Query an examiner by the national provider identifier
 * </p>
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
@Service
public class ExaminerQueryServiceImpl implements ExaminerQueryService {

    private final ExaminerRepository examinersRepository;

    public ExaminerQueryServiceImpl(ExaminerRepository examinerRepository) {
        this.examinersRepository = examinerRepository;
    }

    @Override
    public Optional<Examiner> handle(GetExaminerByNationalIdentifierId query) {
        return examinersRepository.findByNationalProviderIdentifier(new NationalProviderIdentifier(query.nationalIdentifierId()));
        return null;
    }
}