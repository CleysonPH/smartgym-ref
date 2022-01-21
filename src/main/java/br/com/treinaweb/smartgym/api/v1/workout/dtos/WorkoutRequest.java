package br.com.treinaweb.smartgym.api.v1.workout.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.treinaweb.smartgym.api.v1.exercise.validators.ExerciseExistsById;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.validators.WorkoutSheetExistsById;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.validators.WorkoutSheetStatusIsEqualTo;
import br.com.treinaweb.smartgym.core.enums.WorkoutSheetStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutRequest {

    @Positive
    private Double load;

    @Positive
    private Integer frequency;

    @Positive
    private Integer series;

    @Positive
    private Integer rest;

    @NotNull
    @Positive
    @ExerciseExistsById
    private Long exerciseId;

    @NotNull
    @Positive
    @WorkoutSheetExistsById
    @WorkoutSheetStatusIsEqualTo(status = WorkoutSheetStatus.STARTED)
    private Long workoutSheetId;

}
