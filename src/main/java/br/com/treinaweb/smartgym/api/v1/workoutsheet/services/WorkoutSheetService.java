package br.com.treinaweb.smartgym.api.v1.workoutsheet.services;

import java.util.List;

import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetRequest;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetResponse;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.queryfilters.WorkoutSheetQueryFilterImpl;

public interface WorkoutSheetService {

    WorkoutSheetResponse create(WorkoutSheetRequest workoutSheetRequest);

    List<WorkoutSheetResponse> findAll(WorkoutSheetQueryFilterImpl workoutSheetQueryFilter);

    WorkoutSheetResponse findById(Long workoutSheetId);

    void deleteById(Long workoutSheetId);

    WorkoutSheetResponse updateById(Long workoutSheetId, WorkoutSheetRequest workoutSheetRequest);

}
