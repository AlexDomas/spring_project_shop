
package by.bntu.poisit.spring.sprshop.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

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
    @NotBlank(message = "Please enter  address line one!")
    private String addressLineOne;
    
    @Column(name = "address_line_two")
    @NotBlank(message = "Please enter address line two!")
    private String addressLineTwo;
    
    @NotBlank(message = "Please enter city name!")
    private String city;
    
    @NotBlank(message = "Please enter state name!")
    private String state;
    
    @NotBlank(message = "Please enter country name!")
    private String country;
    
    @Column(name = "postal_code")
    @NotBlank(message = "Please enter postal code!")
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
