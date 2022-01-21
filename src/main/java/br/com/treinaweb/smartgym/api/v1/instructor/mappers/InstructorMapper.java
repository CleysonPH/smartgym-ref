package br.com.treinaweb.smartgym.api.v1.instructor.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.treinaweb.smartgym.api.v1.address.mappers.AddressMapper;
import br.com.treinaweb.smartgym.api.v1.instructor.dtos.InstructorRequest;
import br.com.treinaweb.smartgym.api.v1.instructor.dtos.InstructorResponse;
import br.com.treinaweb.smartgym.api.v1.user.mappers.UserMapper;
import br.com.treinaweb.smartgym.core.models.Instructor;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, UserMapper.class})
public interface InstructorMapper {

    InstructorMapper INSTANCE = Mappers.getMapper(InstructorMapper.class);

    Instructor toModel(InstructorRequest instructorRequest);

    InstructorResponse toResponse(Instructor instructor);

}
