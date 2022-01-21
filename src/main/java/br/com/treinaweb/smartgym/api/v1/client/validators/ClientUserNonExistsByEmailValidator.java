package br.com.treinaweb.smartgym.api.v1.client.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import br.com.treinaweb.smartgym.api.v1.user.dtos.UserRequest;
import br.com.treinaweb.smartgym.core.repositories.ClientRepository;
import br.com.treinaweb.smartgym.core.repositories.UserRepository;
import br.com.treinaweb.smartgym.core.utils.HttpServletRequestUtils;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientUserNonExistsByEmailValidator implements ConstraintValidator<ClientUserNonExistsByEmail, UserRequest> {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    @Override
    public boolean isValid(UserRequest value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        var clientId = getClientId();
        if (clientId != null) {
            return !clientRepository.existsById(clientId)
                || clientRepository.existsByIdAndUserEmail(clientId, value.getEmail());
        }
        return !userRepository.existsByEmail(value.getEmail());
    }

    private Long getClientId() {
        return HttpServletRequestUtils.getLongPathVariable("clientId");
    }

}
