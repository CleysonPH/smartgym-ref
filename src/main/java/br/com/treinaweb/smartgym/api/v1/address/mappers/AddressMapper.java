package br.com.treinaweb.smartgym.api.v1.address.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.treinaweb.smartgym.api.v1.address.dtos.AddressRequest;
import br.com.treinaweb.smartgym.api.v1.address.dtos.AddressResponse;
import br.com.treinaweb.smartgym.core.models.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address toModel(AddressRequest addressRequest);

    AddressResponse toResponse(Address address);

}
