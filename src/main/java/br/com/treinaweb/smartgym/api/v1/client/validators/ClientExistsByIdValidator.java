package br.com.treinaweb.smartgym.api.v1.client.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import br.com.treinaweb.smartgym.core.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClientExistsByIdValidator implements ConstraintValidator<ClientExistsById, Long> {

    private final ClientRepository clientRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return clientRepository.existsById(value);
    }

}
