package by.bntu.poisit.spring.sprshop.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import static by.bntu.poisit.spring.sprshop.constant.ErrorMessageConstant.*;
import static by.bntu.poisit.spring.sprshop.constant.RegularExpressionConstant.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
@Table(name = "user_detail")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @NotBlank(message = ERROR_MESSAGE_NOT_BLANK_FIRST_NAME)
    @Size(max = 40, message = ERROR_MESSAGE_INCORRECT_MAX_SIZE_FIRST_NAME)
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = ERROR_MESSAGE_NOT_BLANK_LAST_NAME)
    @Size(max = 40, message = ERROR_MESSAGE_INCORRECT_MAX_SIZE_LAST_NAME)
    private String lastName;

    @Email(message = ERROR_MESSAGE_INCORRECT_FORMAT_OF_EMAIL)
    @NotBlank(message = ERROR_MESSAGE_NOT_BLANK_EMAIL)
    private String email;

    @Column(name = "contact_number")
    @NotBlank(message = ERROR_MESSAGE_NOT_BLANK_PHONE_NUMBER)
    @Pattern(regexp = PHONE_NUMBER_REGULAR_EXPRESSION, message = ERROR_MESSAGE_INCORRECT_FORMAT_PHONE_NUMBER)
    private String contactNumber;

    private String role;

    @NotBlank(message = ERROR_MESSAGE_NOT_BLANK_CURRENT_PASSWORD)
    private String password;

    //confirm password transient field
    @Transient
    private String confirmPassword;

    private boolean enabled = true;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", enabled=" + enabled + ", cart=" + cart + '}';
    }

}
