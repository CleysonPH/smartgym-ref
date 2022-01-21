package br.com.treinaweb.smartgym.api.v1.workoutsheet.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import br.com.treinaweb.smartgym.core.repositories.WorkoutSheetRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WorkoutSheetExistsByIdValidator implements ConstraintValidator<WorkoutSheetExistsById, Long> {

    private final WorkoutSheetRepository workoutSheetRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return workoutSheetRepository.existsById(value);
    }

}
