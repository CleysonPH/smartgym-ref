package br.com.treinaweb.smartgym.api.v1.address.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String publicPlace;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 8)
    private String zipCode;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 5)
    private String number;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String neighborhood;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 30)
    private String city;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 2)
    private String state;

    @Size(max = 255)
    private String complement;

}
