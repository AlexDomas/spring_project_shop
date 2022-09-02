package by.bntu.poisit.spring.sprshop.dto;

import by.bntu.poisit.spring.sprshop.entity.Cart;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import by.bntu.poisit.spring.sprshop.validator.annotation.UniqueEmail;
import javax.validation.constraints.Email;

import static by.bntu.poisit.spring.sprshop.constant.ErrorMessageConstant.*;
import static by.bntu.poisit.spring.sprshop.constant.RegularExpressionConstant.*;
import by.bntu.poisit.spring.sprshop.validator.group.ChangeProfileInfoGroup;


@Getter
@Setter
public class UserProfileDataDto implements Serializable{

    private int id;
    
    @NotBlank(groups = ChangeProfileInfoGroup.class, message = ERROR_MESSAGE_NOT_BLANK_FIRST_NAME)
    @Size(groups = ChangeProfileInfoGroup.class, max = 40, message = ERROR_MESSAGE_INCORRECT_MAX_SIZE_FIRST_NAME)
    private String firstName;
    
    @NotBlank(groups = ChangeProfileInfoGroup.class, message = ERROR_MESSAGE_NOT_BLANK_LAST_NAME)
    @Size(groups = ChangeProfileInfoGroup.class, max = 40, message = ERROR_MESSAGE_INCORRECT_MAX_SIZE_LAST_NAME)
    private String lastName;
    
    @Email(groups = ChangeProfileInfoGroup.class, message = ERROR_MESSAGE_INCORRECT_FORMAT_OF_EMAIL)
    @UniqueEmail(groups = ChangeProfileInfoGroup.class, message = ERROR_MESSAGE_USER_WITH_SUCH_EMAIL_EXISTS)
    @NotBlank(groups = ChangeProfileInfoGroup.class, message = ERROR_MESSAGE_NOT_BLANK_EMAIL)
    private String email;
    
    @NotBlank(groups = ChangeProfileInfoGroup.class, message = ERROR_MESSAGE_NOT_BLANK_PHONE_NUMBER)
    @Pattern(regexp = PHONE_NUMBER_REGULAR_EXPRESSION, groups = ChangeProfileInfoGroup.class,  message = ERROR_MESSAGE_INCORRECT_FORMAT_PHONE_NUMBER)
    private String phoneNumber;
    
    private String role;
    
    private Cart cart;

}
