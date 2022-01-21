package br.com.treinaweb.smartgym.api.v1.user.dtos;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
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
public class UserRequest {

    @Email
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String password;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String passwordConfirmation;

    @AssertTrue(message = "senhas não conferem")
    private boolean isPasswordConfirmation() {
        return password != null
            && passwordConfirmation != null
            && password.equals(passwordConfirmation);
    }

}
