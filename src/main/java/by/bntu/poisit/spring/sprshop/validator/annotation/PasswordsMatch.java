package by.bntu.poisit.spring.sprshop.validator.annotation;

import by.bntu.poisit.spring.sprshop.validator.PasswordsMatchValidator;
import org.springframework.messaging.handler.annotation.Payload;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordsMatchValidator.class})
public @interface PasswordsMatch {
    String message() default "Passwords do not match.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
