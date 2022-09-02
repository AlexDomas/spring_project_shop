package by.bntu.poisit.spring.sprshop.validator;

import by.bntu.poisit.spring.sprshop.service.UserService;
import by.bntu.poisit.spring.sprshop.validator.annotation.UniqueEmail;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueValidator implements ConstraintValidator<UniqueEmail, String> {
    
    private final UserService userService;

    public EmailUniqueValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (!(authentication instanceof AnonymousAuthenticationToken) && authentication.getName().equals(email)) ||
                (email != null && !userService.existsUserByEmail(email));
    }
}
