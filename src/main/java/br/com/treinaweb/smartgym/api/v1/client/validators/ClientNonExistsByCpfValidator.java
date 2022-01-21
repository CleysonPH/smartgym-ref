package br.com.treinaweb.smartgym.api.v1.client.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import br.com.treinaweb.smartgym.core.repositories.ClientRepository;
import br.com.treinaweb.smartgym.core.utils.HttpServletRequestUtils;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientNonExistsByCpfValidator implements ConstraintValidator<ClientNonExistsByCpf, String> {

    private final ClientRepository clientRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        var clientId = getClientId();
        if (clientId != null) {
            return !clientRepository.existsById(clientId)
                || clientRepository.existsByIdAndCpf(clientId, value);
        }
        return !clientRepository.existsByCpf(value);
    }

    private Long getClientId() {
        return HttpServletRequestUtils.getLongPathVariable("clientId");
    }

}
