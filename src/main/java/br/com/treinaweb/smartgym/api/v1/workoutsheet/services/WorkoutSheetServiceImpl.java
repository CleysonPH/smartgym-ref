package br.com.treinaweb.smartgym.api.v1.workoutsheet.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetRequest;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetResponse;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.mappers.WorkoutSheetMapper;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.queryfilters.WorkoutSheetQueryFilterImpl;
import br.com.treinaweb.smartgym.core.enums.WorkoutSheetStatus;
import br.com.treinaweb.smartgym.core.repositories.WorkoutSheetRepository;
import br.com.treinaweb.smartgym.core.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkoutSheetServiceImpl implements WorkoutSheetService {

    private final SecurityUtils securityUtils;
    private final WorkoutSheetMapper workoutSheetMapper;
    private final WorkoutSheetRepository workoutSheetRepository;

    @Override
    public WorkoutSheetResponse create(WorkoutSheetRequest workoutSheetRequest) {
        var workoutSheetToCreate = workoutSheetMapper.toModel(workoutSheetRequest);
        workoutSheetToCreate.setInstructor(securityUtils.getAuthenticatedInstructor());
        workoutSheetToCreate.setStart(LocalDate.now());
        workoutSheetToCreate.setStatus(WorkoutSheetStatus.STARTED);
        var createdWorkoutSheet = workoutSheetRepository.save(workoutSheetToCreate);
        return workoutSheetMapper.toResponse(createdWorkoutSheet);
    }

    @Override
    public List<WorkoutSheetResponse> findAll(WorkoutSheetQueryFilterImpl workoutSheetQueryFilter) {
        return workoutSheetRepository.findWithQueryFilter(workoutSheetQueryFilter)
            .stream()
            .map(workoutSheetMapper::toResponse)
            .toList();
    }

    @Override
    public WorkoutSheetResponse findById(Long workoutSheetId) {
        var foundWorkoutSheet = workoutSheetRepository.findByIdOrElseThrow(workoutSheetId);
        return workoutSheetMapper.toResponse(foundWorkoutSheet);
    }

    @Override
    public void deleteById(Long workoutSheetId) {
        var workoutSheetToDelete = workoutSheetRepository.findByIdOrElseThrow(workoutSheetId);
        workoutSheetRepository.delete(workoutSheetToDelete);
    }

    @Override
    public WorkoutSheetResponse updateById(Long workoutSheetId, WorkoutSheetRequest workoutSheetRequest) {
        var workoutSheetToUpdate = workoutSheetRepository.findByIdOrElseThrow(workoutSheetId);
        var workoutSheetToUpdateData = workoutSheetMapper.toModel(workoutSheetRequest);
        BeanUtils.copyProperties(workoutSheetToUpdateData, workoutSheetToUpdate, "id", "start", "status", "instructor");
        var updatedWorkoutSheet = workoutSheetRepository.save(workoutSheetToUpdate);
        return workoutSheetMapper.toResponse(updatedWorkoutSheet);
    }

}
