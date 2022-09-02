package by.bntu.poisit.spring.sprshop.validator;

import by.bntu.poisit.spring.sprshop.entity.User;
import by.bntu.poisit.spring.sprshop.service.UserService;
import by.bntu.poisit.spring.sprshop.validator.annotation.CurrentPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CurrentPasswordValidator implements ConstraintValidator<CurrentPassword, String> {

    private final UserService userService;
    
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public CurrentPasswordValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String newPassword, ConstraintValidatorContext constraintValidatorContext) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByEmail(authentication.getName());
        return user.isEnabled() && passwordEncoder.matches(newPassword, user.getPassword());
    }
    
}
