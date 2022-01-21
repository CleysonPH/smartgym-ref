package br.com.treinaweb.smartgym.api.v1.workoutsheet.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.treinaweb.smartgym.core.enums.WorkoutSheetStatus;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WorkoutSheetStatusIsEqualToValidator.class)
public @interface WorkoutSheetStatusIsEqualTo {

    String message() default "ficha de treino de id ${validatedValue} não possui o status {status}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    WorkoutSheetStatus status() default WorkoutSheetStatus.STARTED;

    @Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        WorkoutSheetStatusIsEqualTo[] value();
    }

}
