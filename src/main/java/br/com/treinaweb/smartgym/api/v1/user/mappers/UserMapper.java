package br.com.treinaweb.smartgym.api.v1.user.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.treinaweb.smartgym.api.v1.user.dtos.UserRequest;
import br.com.treinaweb.smartgym.api.v1.user.dtos.UserResponse;
import br.com.treinaweb.smartgym.core.enums.Role;
import br.com.treinaweb.smartgym.core.models.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toModel(UserRequest userRequest);

    UserResponse toResponse(User user);

    default String roleToString(Role role) {
        return role.name();
    }

}
