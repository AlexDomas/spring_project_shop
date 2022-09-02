package by.bntu.poisit.spring.sprshop.dto;

import by.bntu.poisit.spring.sprshop.entity.Address;
import by.bntu.poisit.spring.sprshop.entity.User;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private User user;
    private Address billing;
    
}
