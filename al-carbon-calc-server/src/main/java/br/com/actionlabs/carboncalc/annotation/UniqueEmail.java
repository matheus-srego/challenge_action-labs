package br.com.actionlabs.carboncalc.annotation;

import br.com.actionlabs.carboncalc.utils.CONSTANTS;
import br.com.actionlabs.carboncalc.validator.UniqueEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {

    String message() default CONSTANTS.EMAIL_EXIST;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
