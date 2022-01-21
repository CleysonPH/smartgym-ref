package br.com.treinaweb.smartgym.api.v1.exercise.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseRequest;
import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseResponse;
import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseSummaryResponse;
import br.com.treinaweb.smartgym.api.v1.exercise.mappers.ExerciseMapper;
import br.com.treinaweb.smartgym.core.repositories.ExerciseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    @Override
    public ExerciseResponse create(ExerciseRequest exerciseRequest) {
        var exerciseToCreate = exerciseMapper.toModel(exerciseRequest);
        var createdExercise = exerciseRepository.save(exerciseToCreate);
        return exerciseMapper.toResponse(createdExercise);
    }

    @Override
    public List<ExerciseSummaryResponse> findAll() {
        return exerciseRepository.findAll()
            .stream()
            .map(exerciseMapper::toSummaryResponse)
            .toList();
    }

    @Override
    public ExerciseResponse findById(Long exerciseId) {
        return exerciseMapper.toResponse(exerciseRepository.findByIdOrElseThrow(exerciseId));
    }

    @Override
    public ExerciseResponse updateById(Long exerciseId, ExerciseRequest exerciseRequest) {
        var exerciseToUpdate = exerciseRepository.findByIdOrElseThrow(exerciseId);
        var exerciseDataToUpdate = exerciseMapper.toModel(exerciseRequest);
        BeanUtils.copyProperties(exerciseDataToUpdate, exerciseToUpdate, "id");
        var updatedExercise = exerciseRepository.save(exerciseToUpdate);
        return exerciseMapper.toResponse(updatedExercise);
    }

    @Override
    public void deleteById(Long exerciseId) {
        var exerciseToDelete = exerciseRepository.findByIdOrElseThrow(exerciseId);
        exerciseRepository.delete(exerciseToDelete);
    }

}
