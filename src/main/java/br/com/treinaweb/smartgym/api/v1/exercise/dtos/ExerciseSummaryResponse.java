package br.com.treinaweb.smartgym.api.v1.exercise.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseSummaryResponse {

    private Long id;
    private String name;

}
