package com.doctoroffice.entity;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = NationalIdValidator.class)
@Documented
public @interface CheckNationalId {
    String message() default "{com.doctoroffice.constraints}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
