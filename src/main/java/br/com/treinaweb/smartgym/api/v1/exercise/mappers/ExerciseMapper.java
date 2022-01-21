package br.com.treinaweb.smartgym.api.v1.exercise.mappers;

import java.util.List;
import java.util.stream.Stream;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseRequest;
import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseResponse;
import br.com.treinaweb.smartgym.api.v1.exercise.dtos.ExerciseSummaryResponse;
import br.com.treinaweb.smartgym.core.models.Exercise;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {

    ExerciseMapper INSTANCE = Mappers.getMapper(ExerciseMapper.class);

    Exercise toModel(ExerciseRequest exerciseRequest);

    ExerciseResponse toResponse(Exercise exercise);

    ExerciseSummaryResponse toSummaryResponse(Exercise exercise);

    default List<String> stringToStringList(String value) {
        return Stream.of(value.split(";"))
            .map(String::trim)
            .toList();
    }

    default String stringListToString(List<String> value) {
        return String.join(";", value);
    }

}
