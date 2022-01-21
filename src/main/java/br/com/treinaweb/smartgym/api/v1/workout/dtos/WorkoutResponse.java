package br.com.treinaweb.smartgym.api.v1.workout.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutResponse {

    private Double load;
    private Integer frequency;
    private Integer series;
    private Integer rest;
    private Long exerciseId;
    private Long workoutSheetId;

}
