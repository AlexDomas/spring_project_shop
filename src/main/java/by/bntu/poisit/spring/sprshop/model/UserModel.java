package by.bntu.poisit.spring.sprshop.model;

import by.bntu.poisit.spring.sprshop.dto.Cart;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String fullName;
    private String email;
    private String role;
    private Cart cart;

    @Override
    public String toString() {
        return "UserModel{" + "id=" + id + ", fullName=" + fullName + ", email=" + email + ", role=" + role + ", cart=" + cart + '}';
    }
    
}
