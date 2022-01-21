package br.com.treinaweb.smartgym.api.v1.instructor.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import br.com.treinaweb.smartgym.api.v1.user.dtos.UserRequest;
import br.com.treinaweb.smartgym.core.repositories.InstructorRepository;
import br.com.treinaweb.smartgym.core.repositories.UserRepository;
import br.com.treinaweb.smartgym.core.utils.HttpServletRequestUtils;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InstructorUserNonExistsByEmailValidator implements ConstraintValidator<InstructorUserNonExistsByEmail, UserRequest> {

    private final UserRepository userRepository;
    private final InstructorRepository instructorRepository;

    @Override
    public boolean isValid(UserRequest value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        var instructorId = getInstructorId();
        if (instructorId != null) {
            return instructorRepository.existsByIdAndUserEmail(instructorId, value.getEmail());
        }
        return !userRepository.existsByEmail(value.getEmail());
    }

    private Long getInstructorId() {
        return HttpServletRequestUtils.getLongPathVariable("instructorId");
    }

}
