package br.com.treinaweb.smartgym.api.v1.exercise.controllers;

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

import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseRequest;
import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseResponse;
import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseSummaryResponse;
import br.com.treinaweb.smartgym.api.v1.exercise.routes.ExerciseRoutes;
import br.com.treinaweb.smartgym.api.v1.exercise.services.ExerciseService;
import br.com.treinaweb.smartgym.core.permissions.SmartGymPermissions;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ExerciseRestControllerImpl implements ExerciseRestController {

    private final ExerciseService exerciseService;

    @Override
    @SmartGymPermissions.isAdmin
    @PostMapping(ExerciseRoutes.CREATE_ROUTE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ExerciseResponse create(@RequestBody @Valid ExerciseRequest exerciseRequest) {
        return exerciseService.create(exerciseRequest);
    }

    @Override
    @SmartGymPermissions.isAuthenticated
    @GetMapping(ExerciseRoutes.FIND_ALL_ROUTE)
    public List<ExerciseSummaryResponse> findAll() {
        return exerciseService.findAll();
    }

    @Override
    @SmartGymPermissions.isAuthenticated
    @GetMapping(ExerciseRoutes.FIND_BY_ID_ROUTE)
    public ExerciseResponse findById(@PathVariable Long exerciseId) {
        return exerciseService.findById(exerciseId);
    }

    @Override
    @SmartGymPermissions.isAdmin
    @PutMapping(ExerciseRoutes.UPDATE_BY_ID_ROUTE)
    public ExerciseResponse updateById(
        @PathVariable Long exerciseId,
        @RequestBody @Valid ExerciseRequest exerciseRequest
    ) {
        return exerciseService.updateById(exerciseId, exerciseRequest);
    }

    @Override
    @SmartGymPermissions.isAdmin
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(ExerciseRoutes.DELETE_BY_ID_ROUTE)
    public void deleteById(@PathVariable Long exerciseId) {
        exerciseService.deleteById(exerciseId);
    }

}
