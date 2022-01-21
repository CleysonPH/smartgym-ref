package br.com.treinaweb.smartgym.api.v1.workout.services;

import br.com.treinaweb.smartgym.api.v1.workout.dtos.WorkoutRequest;
import br.com.treinaweb.smartgym.api.v1.workout.dtos.WorkoutResponse;

public interface WorkoutService {

    WorkoutResponse create(WorkoutRequest workoutRequest);

    WorkoutResponse findById(Long workoutId);

    WorkoutResponse updateById(Long workoutId, WorkoutRequest workoutRequest);

    void deleteById(Long workoutId);

}
