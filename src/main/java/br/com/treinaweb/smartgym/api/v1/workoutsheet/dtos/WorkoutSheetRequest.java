package br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.treinaweb.smartgym.api.v1.client.validators.ClientExistsById;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutSheetRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String name;

    @Future
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate end;

    @NotNull
    @Positive
    @ClientExistsById
    private Long clientId;

}
