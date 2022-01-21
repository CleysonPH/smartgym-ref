package br.com.treinaweb.smartgym.api.v1.workoutsheet.queryfilters;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.treinaweb.smartgym.core.enums.WorkoutSheetStatus;
import br.com.treinaweb.smartgym.core.queryfilters.WorkoutSheetQueryFilter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutSheetQueryFilterImpl implements WorkoutSheetQueryFilter {

    private String name;

    private WorkoutSheetStatus status;

    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate startGte;

    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate startLte;

    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate endGte;

    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate endLte;

    private String client;

    private String instructor;

}
