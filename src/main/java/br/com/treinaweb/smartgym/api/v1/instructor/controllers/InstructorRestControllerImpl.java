package br.com.treinaweb.smartgym.api.v1.instructor.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.smartgym.api.v1.instructor.dtos.InstructorRequest;
import br.com.treinaweb.smartgym.api.v1.instructor.dtos.InstructorResponse;
import br.com.treinaweb.smartgym.api.v1.instructor.routes.InstructorRoutes;
import br.com.treinaweb.smartgym.api.v1.instructor.services.InstructorService;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetResponse;
import br.com.treinaweb.smartgym.core.permissions.SmartGymPermissions;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class InstructorRestControllerImpl implements InstructorRestController {

    private final InstructorService instructorService;

    @Override
    @SmartGymPermissions.isAdmin
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(InstructorRoutes.CREATE_ROUTE)
    public InstructorResponse create(@RequestBody @Valid InstructorRequest instructorRequest) {
        return instructorService.create(instructorRequest);
    }

    @Override
    @SmartGymPermissions.isInstructorOrAdmin
    @GetMapping(InstructorRoutes.FIND_WORKOUTSHEETS_BY_INSTRUCTOR_ID)
    public List<WorkoutSheetResponse> findInstructorWorkoutSheets(@PathVariable Long instructorId) {
        return instructorService.findInstructorWorkoutSheets(instructorId);
    }

}
