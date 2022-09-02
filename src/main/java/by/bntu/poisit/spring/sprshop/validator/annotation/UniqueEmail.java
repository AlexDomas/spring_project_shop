package by.bntu.poisit.spring.sprshop.validator.annotation;

import by.bntu.poisit.spring.sprshop.validator.EmailUniqueValidator;
import org.springframework.messaging.handler.annotation.Payload;
import javax.validation.Constraint;
import java.lang.annotation.*;

import static by.bntu.poisit.spring.sprshop.constant.ErrorMessageConstant.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmailUniqueValidator.class})
public @interface UniqueEmail {
    String message() default ERROR_MESSAGE_USER_WITH_SUCH_EMAIL_EXISTS;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
