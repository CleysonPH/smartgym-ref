package br.com.treinaweb.smartgym.api.v1.workoutsheet.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetRequest;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetResponse;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.queryfilters.WorkoutSheetQueryFilterImpl;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.routes.WorkoutSheetRoutes;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.services.WorkoutSheetService;
import br.com.treinaweb.smartgym.core.permissions.SmartGymPermissions;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class WorkoutSheetRestControllerImpl implements WorkoutSheetRestController {

    private final WorkoutSheetService workoutSheetService;

    @Override
    @SmartGymPermissions.isInstructor
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(WorkoutSheetRoutes.CREATE_ROUTE)
    public WorkoutSheetResponse create(
        @RequestBody @Valid WorkoutSheetRequest workoutSheetRequest
    ) {
        return workoutSheetService.create(workoutSheetRequest);
    }

    @Override
    @SmartGymPermissions.isInstructorOrAdmin
    @GetMapping(WorkoutSheetRoutes.FIND_ALL_ROUTE)
    public List<WorkoutSheetResponse> findAll(
        WorkoutSheetQueryFilterImpl workoutSheetQueryFilter
    ) {
        return workoutSheetService.findAll(workoutSheetQueryFilter);
    }

    @Override
    @GetMapping(WorkoutSheetRoutes.FIND_BY_ID)
    @SmartGymPermissions.isInstructorOrAdminOrClientOwnerOfWorkoutSheet
    public WorkoutSheetResponse findById(@PathVariable Long workoutSheetId) {
        return workoutSheetService.findById(workoutSheetId);
    }

    @Override
    @SmartGymPermissions.isInstructor
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(WorkoutSheetRoutes.DELETE_BY_ID)
    public void deleteById(@PathVariable Long workoutSheetId) {
        workoutSheetService.deleteById(workoutSheetId);
    }

    @Override
    @SmartGymPermissions.isInstructor
    @PutMapping(WorkoutSheetRoutes.UPDATE_BY_ID)
    public WorkoutSheetResponse updateById(
        @PathVariable Long workoutSheetId,
        @RequestBody @Valid WorkoutSheetRequest workoutSheetRequest
    ) {
        return workoutSheetService.updateById(workoutSheetId, workoutSheetRequest);
    }

}
