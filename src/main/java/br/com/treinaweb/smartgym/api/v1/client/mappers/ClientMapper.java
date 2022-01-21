package br.com.treinaweb.smartgym.api.v1.client.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.treinaweb.smartgym.api.v1.address.mappers.AddressMapper;
import br.com.treinaweb.smartgym.api.v1.client.dtos.ClientRequest;
import br.com.treinaweb.smartgym.api.v1.client.dtos.ClienteResponse;
import br.com.treinaweb.smartgym.api.v1.user.mappers.UserMapper;
import br.com.treinaweb.smartgym.core.models.Client;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, UserMapper.class})
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toModel(ClientRequest clientRequest);

    ClienteResponse toResponse(Client client);

}
