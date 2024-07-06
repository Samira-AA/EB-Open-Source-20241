package org.hign.platform.si729ebu20211a046.personnel.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.si729ebu20211a046.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.si729ebu20211a046.personnel.interfaces.rest.resources.CreateExaminerResource;
import org.hign.platform.si729ebu20211a046.personnel.interfaces.rest.resources.ExaminerResource;
import org.hign.platform.si729ebu20211a046.personnel.interfaces.rest.transform.CreateExaminerCommandFromResourceAssembler;
import org.hign.platform.si729ebu20211a046.personnel.interfaces.rest.transform.ExaminerResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Examiner Controller
 * <p>
 *     This controller is used to create a new examiner.
 *  </p>
 *  @version 1.0
 * @author Samira Alvarez Araguache
 */
@RestController
@RequestMapping(value = "/api/v1/examiners", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Examiners", description = "Examiner Management Endpoints")
public class ExaminerController {

    private final ExaminerCommandService examinerCommandService;

    public ExaminerController(ExaminerCommandService examinerCommandService) {
        this.examinerCommandService = examinerCommandService;
    }

    /**
     * Create a new examiner using resources {@link CreateExaminerResource}
     * @param resource {@link CreateExaminerResource}
     * @return resource {@link ExaminerResource} with the created examiner information
     */

    @Operation(summary = "Create a new examiner",
            description = "Create a new examiner with the provided information.\n National Provider Identifier must be unique and in uuid v4 format")
    @PostMapping
    public ResponseEntity<ExaminerResource> createExaminer(@RequestBody CreateExaminerResource resource) {
        var command = CreateExaminerCommandFromResourceAssembler.toCommandFromResource(resource);
        var examiner = examinerCommandService.handle(command).orElseThrow(() -> new RuntimeException("An error occurred while creating examiner"));
        var examinerResource = ExaminerResourceFromEntityAssembler.toResourceFromEntity(examiner);
        return new ResponseEntity<>(examinerResource, HttpStatus.CREATED);
    }
}
