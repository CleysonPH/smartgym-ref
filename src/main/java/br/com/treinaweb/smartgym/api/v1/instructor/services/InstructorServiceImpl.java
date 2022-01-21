package br.com.treinaweb.smartgym.api.v1.instructor.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.treinaweb.smartgym.api.v1.instructor.dtos.InstructorRequest;
import br.com.treinaweb.smartgym.api.v1.instructor.dtos.InstructorResponse;
import br.com.treinaweb.smartgym.api.v1.instructor.mappers.InstructorMapper;
import br.com.treinaweb.smartgym.api.v1.user.services.UserService;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetResponse;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.mappers.WorkoutSheetMapper;
import br.com.treinaweb.smartgym.core.repositories.InstructorRepository;
import br.com.treinaweb.smartgym.core.repositories.WorkoutSheetRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final UserService userService;
    private final InstructorMapper instructorMapper;
    private final WorkoutSheetMapper workoutSheetMapper;
    private final InstructorRepository instructorRepository;
    private final WorkoutSheetRepository workoutSheetRepository;

    @Override
    public InstructorResponse create(InstructorRequest instructorRequest) {
        var instructorToCreate = instructorMapper.toModel(instructorRequest);
        var createdUser = userService.createInstructor(instructorToCreate.getUser());
        instructorToCreate.setUser(createdUser);
        var createdInstructor = instructorRepository.save(instructorToCreate);
        return instructorMapper.toResponse(createdInstructor);
    }

    @Override
    public List<WorkoutSheetResponse> findInstructorWorkoutSheets(Long instructorId) {
        var foundInstructor = instructorRepository.findByIdOrElseThrow(instructorId);
        return workoutSheetRepository.findByInstructor(foundInstructor)
            .stream()
            .map(workoutSheetMapper::toResponse)
            .toList();
    }

}
