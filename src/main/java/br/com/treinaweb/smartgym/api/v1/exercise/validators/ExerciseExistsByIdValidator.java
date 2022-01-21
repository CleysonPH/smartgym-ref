package br.com.treinaweb.smartgym.api.v1.exercise.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import br.com.treinaweb.smartgym.core.repositories.ExerciseRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExerciseExistsByIdValidator implements ConstraintValidator<ExerciseExistsById, Long> {

    private final ExerciseRepository exerciseRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return exerciseRepository.existsById(value);
    }

}
