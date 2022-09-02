package by.bntu.poisit.spring.sprshop.validator;

import by.bntu.poisit.spring.sprshop.dto.ChangePasswordDto;
import by.bntu.poisit.spring.sprshop.validator.annotation.PasswordsMatch;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, ChangePasswordDto> {
    
    @Override
    public boolean isValid(ChangePasswordDto changePasswordDto, ConstraintValidatorContext constraintValidatorContext) {
        String password = changePasswordDto.getNewPassword();
        return password != null && password.equals(changePasswordDto.getConfirmNewPassword());
    }
    
}
