package br.com.treinaweb.smartgym.api.v1.instructor.services;

import java.util.List;

import br.com.treinaweb.smartgym.api.v1.instructor.dtos.InstructorRequest;
import br.com.treinaweb.smartgym.api.v1.instructor.dtos.InstructorResponse;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetResponse;

public interface InstructorService {

    InstructorResponse create(InstructorRequest instructorRequest);

    List<WorkoutSheetResponse> findInstructorWorkoutSheets(Long instructorId);

}
