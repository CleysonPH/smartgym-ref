package br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutSheetResponse {

    private Long id;
    private String name;
    private LocalDate start;
    private LocalDate end;
    private String status;
    private Long instructorId;
    private Long clientId;

}
