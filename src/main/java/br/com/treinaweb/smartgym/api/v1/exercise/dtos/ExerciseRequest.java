package br.com.treinaweb.smartgym.api.v1.exercise.dtos;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String preparation;

    @NotNull
    @NotEmpty
    private List<String> execution;

    @NotNull
    @NotEmpty
    private List<String> tips;

}
