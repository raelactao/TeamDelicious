package com.teamdelicious.appadvc2223.t.services;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ReservationValidation.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ReservationDateTimeConstraint {

    String message() default "This time has already been reserved.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
