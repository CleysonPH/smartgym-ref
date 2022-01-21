package br.com.treinaweb.smartgym.core.queryfilters;

import java.time.LocalDate;

import br.com.treinaweb.smartgym.core.enums.WorkoutSheetStatus;

public interface WorkoutSheetQueryFilter {

    String getName();
    String getClient();
    LocalDate getEndLte();
    LocalDate getEndGte();
    LocalDate getStartGte();
    LocalDate getStartLte();
    String getInstructor();
    WorkoutSheetStatus getStatus();

}
