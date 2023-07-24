package com.example.TechnicalInterview.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CapacityStadiumValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CapacityStadium {

    String message() default "The capacity of stadium must be greater";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

