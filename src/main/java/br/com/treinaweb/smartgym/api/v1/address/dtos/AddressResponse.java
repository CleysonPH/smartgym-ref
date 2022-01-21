package br.com.treinaweb.smartgym.api.v1.address.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {

    private String publicPlace;
    private String zipCode;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String complement;

}
