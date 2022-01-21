package br.com.treinaweb.smartgym.api.v1.exercise.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseResponse {

    private Long id;
    private String name;
    private String preparation;
    private List<String> execution;
    private List<String> tips;

}
