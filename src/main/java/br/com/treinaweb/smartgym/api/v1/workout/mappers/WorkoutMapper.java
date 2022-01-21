package br.com.treinaweb.smartgym.api.v1.workout.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.treinaweb.smartgym.api.v1.workout.dtos.WorkoutRequest;
import br.com.treinaweb.smartgym.api.v1.workout.dtos.WorkoutResponse;
import br.com.treinaweb.smartgym.core.models.Exercise;
import br.com.treinaweb.smartgym.core.models.Workout;
import br.com.treinaweb.smartgym.core.models.WorkoutSheet;
import br.com.treinaweb.smartgym.core.repositories.ExerciseRepository;
import br.com.treinaweb.smartgym.core.repositories.WorkoutSheetRepository;

@Mapper(componentModel = "spring")
public abstract class WorkoutMapper {

    @Autowired
    protected ExerciseRepository exerciseRepository;

    @Autowired
    protected WorkoutSheetRepository workoutSheetRepository;

    public static final WorkoutMapper INSTANCE = Mappers.getMapper(WorkoutMapper.class);

    @Mapping(target = "exercise", source = "exerciseId")
    @Mapping(target = "workoutSheet", source = "workoutSheetId")
    public abstract Workout toModel(WorkoutRequest workoutRequest);

    @Mapping(target = "exerciseId", source = "exercise.id")
    @Mapping(target = "workoutSheetId", source = "workoutSheet.id")
    public abstract WorkoutResponse toResponse(Workout workout);

    protected Exercise longToExercise(Long exerciseId) {
        return exerciseRepository.findByIdOrElseThrow(exerciseId);
    }

    protected WorkoutSheet longToWorkoutSheet(Long workoutSheetId) {
        return workoutSheetRepository.findByIdOrElseThrow(workoutSheetId);
    }

}
