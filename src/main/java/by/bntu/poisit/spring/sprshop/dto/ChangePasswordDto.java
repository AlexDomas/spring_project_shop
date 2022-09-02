package by.bntu.poisit.spring.sprshop.dto;

import javax.validation.constraints.Pattern;

import static by.bntu.poisit.spring.sprshop.constant.RegularExpressionConstant.*;
import by.bntu.poisit.spring.sprshop.validator.annotation.CurrentPassword;
import by.bntu.poisit.spring.sprshop.validator.annotation.PasswordsMatch;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import static by.bntu.poisit.spring.sprshop.constant.ErrorMessageConstant.*;

@Getter
@Setter
@PasswordsMatch
public class ChangePasswordDto implements Serializable{
    
    @NotBlank(message = ERROR_MESSAGE_NOT_BLANK_CURRENT_PASSWORD)
    @CurrentPassword
    private String currentPassword;
    
    @NotBlank(message = ERROR_MESSAGE_NOT_BLANK_NEW_PASSWORD)
    @Pattern(regexp = PASSWORD_REGULAR_EXPRESSION, message = ERROR_MESSAGE_INCORRECT_FORMAT_OF_PASSWORD)
    private String newPassword;
    
    @NotBlank(message = ERROR_MESSAGE_NOT_BLANK_CONFIRM_NEW_PASSWORD)
    @Pattern(regexp = PASSWORD_REGULAR_EXPRESSION, message = ERROR_MESSAGE_INCORRECT_FORMAT_OF_PASSWORD)
    private String confirmNewPassword;

    public ChangePasswordDto() {
    }

    public ChangePasswordDto(String currentPassword, String newPassword, String confirmNewPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.confirmNewPassword = confirmNewPassword;
    }

    
}
