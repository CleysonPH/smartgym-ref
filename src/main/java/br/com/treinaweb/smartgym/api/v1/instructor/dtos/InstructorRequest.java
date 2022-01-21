package br.com.treinaweb.smartgym.api.v1.instructor.dtos;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.com.treinaweb.smartgym.api.v1.address.dtos.AddressRequest;
import br.com.treinaweb.smartgym.api.v1.instructor.validators.InstructorNonExistsByCpf;
import br.com.treinaweb.smartgym.api.v1.instructor.validators.InstructorUserNonExistsByEmail;
import br.com.treinaweb.smartgym.api.v1.user.dtos.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstructorRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String name;

    @CPF
    @NotNull
    @NotEmpty
    @InstructorNonExistsByCpf
    @Size(min = 11, max = 11)
    private String cpf;

    @Past
    @NotNull
    private LocalDate birthDate;

    @NotNull
    @NotEmpty
    @Size(min = 11, max = 11)
    private String phone;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String confef;

    @Valid
    @NotNull
    private AddressRequest address;

    @Valid
    @NotNull
    @InstructorUserNonExistsByEmail
    private UserRequest user;

}
