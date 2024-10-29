package br.com.actionlabs.carboncalc.annotation;

import br.com.actionlabs.carboncalc.utils.CONSTANTS;
import br.com.actionlabs.carboncalc.validator.UniquePhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniquePhoneNumberValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniquePhoneNumber {

    String message() default CONSTANTS.PHONE_NUMBER_EXIST;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
