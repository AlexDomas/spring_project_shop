
package by.bntu.poisit.spring.sprshop.dto;

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
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "user_detail")
public class User implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "first_name")
    @NotBlank(message = "Please enter first name!")
    private String firstName;
    
    @Column(name = "last_name")
    @NotBlank(message = "Please enter last name!")
    private String lastName;
    
    @NotBlank(message = "Please enter email address!")
    private String email;
    
    @Column(name = "contact_number")
    @NotBlank(message = "Please enter contact number!")
    private String contactNumber;
    
    private String role;
    
    @NotBlank(message = "Please enter password!")
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
