package br.com.treinaweb.smartgym.api.v1.workoutsheet.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetRequest;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.dtos.WorkoutSheetResponse;
import br.com.treinaweb.smartgym.core.models.Client;
import br.com.treinaweb.smartgym.core.models.WorkoutSheet;
import br.com.treinaweb.smartgym.core.repositories.ClientRepository;

@Mapper(componentModel = "spring")
public abstract class WorkoutSheetMapper {

    @Autowired
    protected ClientRepository clientRepository;

    public static final WorkoutSheetMapper INSTANCE = Mappers.getMapper(WorkoutSheetMapper.class);

    @Mapping(target = "client", source = "clientId")
    public abstract WorkoutSheet toModel(WorkoutSheetRequest workoutSheetRequest);

    @Mapping(target = "instructorId", source = "instructor.id")
    @Mapping(target = "clientId", source = "client.id")
    public abstract WorkoutSheetResponse toResponse(WorkoutSheet workoutSheet);

    protected Client longToClient(Long value) {
        return clientRepository.findById(value)
            .orElseThrow(IllegalArgumentException::new);
    }

}
