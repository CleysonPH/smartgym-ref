package br.com.treinaweb.smartgym.api.v1.exercise.services;

import java.util.List;

import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseRequest;
import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseResponse;
import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseSummaryResponse;

public interface ExerciseService {

    ExerciseResponse create(ExerciseRequest exerciseRequest);

    List<ExerciseSummaryResponse> findAll();

    ExerciseResponse findById(Long exerciseId);

    ExerciseResponse updateById(Long exerciseId, ExerciseRequest exerciseRequest);

    void deleteById(Long exerciseId);

}
