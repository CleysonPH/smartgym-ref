package br.com.treinaweb.smartgym.api.v1.client.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ClientUserNonExistsByEmailValidator.class)
public @interface ClientUserNonExistsByEmail {

    String message() default "email já cadastrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
