package br.com.treinaweb.smartgym.api.v1.workout.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.treinaweb.smartgym.api.v1.workout.dtos.WorkoutRequest;
import br.com.treinaweb.smartgym.api.v1.workout.dtos.WorkoutResponse;
import br.com.treinaweb.smartgym.api.v1.workout.mappers.WorkoutMapper;
import br.com.treinaweb.smartgym.core.repositories.WorkoutRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutMapper workoutMapper;
    private final WorkoutRepository workoutRepository;

    @Override
    public WorkoutResponse create(WorkoutRequest workoutRequest) {
        var workoutToCreate = workoutMapper.toModel(workoutRequest);
        var createdWorkout = workoutRepository.save(workoutToCreate);
        return workoutMapper.toResponse(createdWorkout);
    }

    @Override
    public WorkoutResponse findById(Long workoutId) {
        var foundWorkout = workoutRepository.findByIdOrElseThrow(workoutId);
        return workoutMapper.toResponse(foundWorkout);
    }

    @Override
    public WorkoutResponse updateById(Long workoutId, WorkoutRequest workoutRequest) {
        var workoutToUpdate = workoutRepository.findByIdOrElseThrow(workoutId);
        var workoutToUpdateData = workoutMapper.toModel(workoutRequest);
        BeanUtils.copyProperties(workoutToUpdateData, workoutToUpdate, "id");
        var updatedWorkout = workoutRepository.save(workoutToUpdate);
        return workoutMapper.toResponse(updatedWorkout);
    }

    @Override
    public void deleteById(Long workoutId) {
        var foundWorkout = workoutRepository.findByIdOrElseThrow(workoutId);
        workoutRepository.delete(foundWorkout);
    }

}
