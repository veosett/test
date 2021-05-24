package com.example.quote.validator;

import javax.validation.*;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = { QuoteValidator.class })
public @interface QuoteConstraint {
    String message() default "{QuoteConstraint.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String[] allowed() default {"dairy", "grain"};
}
