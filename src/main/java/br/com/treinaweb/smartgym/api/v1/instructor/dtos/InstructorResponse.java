package br.com.treinaweb.smartgym.api.v1.instructor.dtos;

import java.time.LocalDate;

import br.com.treinaweb.smartgym.api.v1.address.dtos.AddressResponse;
import br.com.treinaweb.smartgym.api.v1.user.dtos.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstructorResponse {

    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private String phone;
    private AddressResponse address;
    private UserResponse user;

}
