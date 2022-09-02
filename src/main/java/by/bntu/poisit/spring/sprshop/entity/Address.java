
package by.bntu.poisit.spring.sprshop.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import static by.bntu.poisit.spring.sprshop.constant.ErrorMessageConstant.*;

@Getter @Setter
@Entity
public class Address implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "address_line_one")
    @NotBlank(message = ERROR_MESSAGE_NOT_BLANK_ADDRESS_LINE_ONE)
    @Size(max = 40, message = ERROR_MESSAGE_INCORRECT_SIZE_OF_ADDRESS_LINE_ONE)
    private String addressLineOne;
    
    @Column(name = "address_line_two")
    @NotBlank(message = ERROR_MESSAGE_NOT_BLANK_ADDRESS_LINE_TWO)
    @Size(max = 40, message = ERROR_MESSAGE_INCORRECT_SIZE_OF_ADDRESS_LINE_TWO)
    private String addressLineTwo;
    
    @NotBlank(message = ERROR_MESSAGE_NOT_BLANK_CITY)
    @Size(max = 40, message = ERROR_MESSAGE_INCORRECT_SIZE_OF_CITY)
    private String city;
    
    @NotBlank(message = ERROR_MESSAGE_NOT_BLANK_STATE)
    @Size(max = 40, message = ERROR_MESSAGE_INCORRECT_SIZE_OF_STATE)
    private String state;
    
    @NotBlank(message = ERROR_MESSAGE_NOT_BLANK_COUNTRY)
    @Size(max = 40, message = ERROR_MESSAGE_INCORRECT_SIZE_OF_COUNTRY)
    private String country;
    
    @Column(name = "postal_code")
    @NotBlank(message = ERROR_MESSAGE_NOT_BLANK_POSTAL_CODE)
    @Size(max = 40, message = ERROR_MESSAGE_INCORRECT_SIZE_OF_POSTAL_CODE)
    private String postalCode;
    
    @Column(name = "is_shipping")
    private boolean shipping;
    
    @Column(name = "is_billing")
    private boolean billing;

    @Override
    public String toString() {
        return "Address{" + "id=" + id +  ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode + ", shipping=" + shipping + ", billing=" + billing + '}';
    }
    
}
