package br.com.treinaweb.smartgym.api.v1.exercise.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExerciseExistsByIdValidator.class)
public @interface ExerciseExistsById {

    String message() default "exercício de id ${validatedValue} não existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
