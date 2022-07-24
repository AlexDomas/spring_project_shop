
package by.bntu.poisit.spring.sprshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    private User user;
    
    @Column(name = "address_line_one")
    private String addressLineOne;
    @Column(name = "address_line_two")
    private String addressLineTwo;
    private String city;
    private String state;
    private String country;
    @Column(name = "postal_code")
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
