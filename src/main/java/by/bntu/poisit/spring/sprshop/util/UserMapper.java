package by.bntu.poisit.spring.sprshop.util;

import by.bntu.poisit.spring.sprshop.dto.User;
import by.bntu.poisit.spring.sprshop.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    
    public UserModel toUserModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setEmail(user.getEmail());
        userModel.setRole(user.getRole());
        userModel.setFullName(user.getFirstName() + " " + user.getLastName());
        if(userModel.getRole().equals("USER")){
            userModel.setCart(user.getCart());
        }
        return userModel;
    }
    
}
