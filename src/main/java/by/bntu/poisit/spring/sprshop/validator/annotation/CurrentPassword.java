package by.bntu.poisit.spring.sprshop.validator.annotation;

import by.bntu.poisit.spring.sprshop.validator.CurrentPasswordValidator;
import org.springframework.messaging.handler.annotation.Payload;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static by.bntu.poisit.spring.sprshop.constant.ErrorMessageConstant.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CurrentPasswordValidator.class})
public @interface CurrentPassword {

    String message() default ERROR_MESSAGE_INCORRECT_CURRENT_PASSWORD;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}
