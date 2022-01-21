package br.com.treinaweb.smartgym.api.v1.instructor.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import br.com.treinaweb.smartgym.core.repositories.InstructorRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InstructorNonExistsByCpfValidator implements ConstraintValidator<InstructorNonExistsByCpf, String> {

    private final InstructorRepository instructorRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return !instructorRepository.existsByCpf(value);
    }

}
