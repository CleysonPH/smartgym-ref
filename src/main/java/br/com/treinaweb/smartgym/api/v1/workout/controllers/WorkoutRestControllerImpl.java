package br.com.treinaweb.smartgym.api.v1.workout.controllers;

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

import br.com.treinaweb.smartgym.api.v1.workout.dtos.WorkoutRequest;
import br.com.treinaweb.smartgym.api.v1.workout.dtos.WorkoutResponse;
import br.com.treinaweb.smartgym.api.v1.workout.routes.WorkoutRoutes;
import br.com.treinaweb.smartgym.api.v1.workout.services.WorkoutService;
import br.com.treinaweb.smartgym.core.permissions.SmartGymPermissions;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class WorkoutRestControllerImpl implements WorkoutRestController {

    private final WorkoutService workoutService;

    @Override
    @SmartGymPermissions.isInstructor
    @PostMapping(WorkoutRoutes.CREATE_ROUTE)
    public WorkoutResponse create(@RequestBody @Valid WorkoutRequest workoutRequest) {
        return workoutService.create(workoutRequest);
    }

    @Override
    @GetMapping(WorkoutRoutes.FIND_BY_ID)
    @SmartGymPermissions.isAdminOrInstructorOrClientOwnerOfWorkout
    public WorkoutResponse findById(@PathVariable Long workoutId) {
        return workoutService.findById(workoutId);
    }

    @Override
    @SmartGymPermissions.isInstructor
    @PutMapping(WorkoutRoutes.UPDATE_BY_ID)
    public WorkoutResponse updateById(
        @PathVariable Long workoutId,
        @RequestBody @Valid WorkoutRequest workoutRequest
    ) {
        return workoutService.updateById(workoutId, workoutRequest);
    }

    @Override
    @SmartGymPermissions.isInstructor
    @DeleteMapping(WorkoutRoutes.DELETE_BY_ID)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long workoutId) {
        workoutService.deleteById(workoutId);
    }

}
