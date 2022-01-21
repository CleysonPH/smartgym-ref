package br.com.treinaweb.smartgym.api.v1.workoutsheet.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import br.com.treinaweb.smartgym.core.enums.WorkoutSheetStatus;
import br.com.treinaweb.smartgym.core.repositories.WorkoutSheetRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WorkoutSheetStatusIsEqualToValidator implements ConstraintValidator<WorkoutSheetStatusIsEqualTo, Long> {

    private final WorkoutSheetRepository workoutSheetRepository;

    private WorkoutSheetStatus status;

    @Override
    public void initialize(WorkoutSheetStatusIsEqualTo constraintAnnotation) {
        status = constraintAnnotation.status();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null || !workoutSheetRepository.existsById(value)) {
            return true;
        }
        return workoutSheetRepository.existsByIdAndStatus(value, status);
    }

}
