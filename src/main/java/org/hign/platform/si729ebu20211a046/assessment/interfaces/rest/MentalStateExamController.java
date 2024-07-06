package org.hign.platform.si729ebu20211a046.assessment.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.si729ebu20211a046.assessment.domain.services.MentalStateExamCommandService;
import org.hign.platform.si729ebu20211a046.assessment.interfaces.rest.resources.CreateMentalStateExamResource;
import org.hign.platform.si729ebu20211a046.assessment.interfaces.rest.resources.MentalStateExamResource;
import org.hign.platform.si729ebu20211a046.assessment.interfaces.rest.transform.CreateMentalStateExamCommandFromResourceAssembler;
import org.hign.platform.si729ebu20211a046.assessment.interfaces.rest.transform.MentalStateExaminerResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Mental State Exam Controller
 * <p>
 *     This controller is used to create a new mental state exam.
 * </p>
 * @author Samira Alvarez Araguache
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/v1/mental-state-exam", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mental State Exam", description = "Mental State Exam Controller")
public class MentalStateExamController {

    private final MentalStateExamCommandService mentalStateExamCommandService;

    public MentalStateExamController(MentalStateExamCommandService mentalStateExamCommandService) {
        this.mentalStateExamCommandService = mentalStateExamCommandService;
    }

    /**
     * Create a new mental state exam.
     * <p>
     *     Provide a valid examiner National Provider Identifier following uuid v4 format, e.g. 123e4567-e89b-12d3-a456-426614174000
     * </p>
     * @param resource as {@link CreateMentalStateExamResource}
     * @return a {@link ResponseEntity<MentalStateExamResource>}
     */

    @Operation(summary = "Create a new mental state exam",
            description = "Provide a valid examiner National Provider Identifier following uuid v4 format, e.g. 123e4567-e89b-12d3-a456-426614174000\nAnd a valid date format, e.g. yyyy-MM-dd"
    )
    @PostMapping
    public ResponseEntity<MentalStateExamResource> createMentalStateExam(@RequestBody CreateMentalStateExamResource resource) {
        var command = CreateMentalStateExamCommandFromResourceAssembler.toCommandFromResource(resource);
        var mentalStateExam = mentalStateExamCommandService.handle(command).orElseThrow(() -> new RuntimeException("An error occurred while creating mental state exam"));
        var mentalStateExamResource = MentalStateExaminerResourceFromEntityAssembler.toResourceFromEntity(mentalStateExam);
        return new ResponseEntity<>(mentalStateExamResource, HttpStatus.CREATED);

    }
}
