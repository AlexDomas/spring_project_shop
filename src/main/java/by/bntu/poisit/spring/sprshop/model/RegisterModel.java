package by.bntu.poisit.spring.sprshop.model;

import by.bntu.poisit.spring.sprshop.dto.Address;
import by.bntu.poisit.spring.sprshop.dto.User;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterModel implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private User user;
    private Address billing;
    
}
