package by.bntu.poisit.spring.sprshop.handler;

import by.bntu.poisit.spring.sprshop.dto.Address;
import by.bntu.poisit.spring.sprshop.dto.Cart;
import by.bntu.poisit.spring.sprshop.dto.User;
import by.bntu.poisit.spring.sprshop.model.RegisterModel;
import by.bntu.poisit.spring.sprshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private UserService userService;
    
    public RegisterModel init(){
        
        return new RegisterModel();
        
    }
    
    public void addUser(RegisterModel registerModel, User user){
        
        registerModel.setUser(user);
        
    }
    
    public void addBilling(RegisterModel registerModel, Address billing){
        
        registerModel.setBilling(billing);
        
    }
    
    public String validateUser(User user, MessageContext error){
        
        String transitionValue = "success";
        
        //checking if password matches confirm password
        
        if(!(user.getPassword().equals(user.getConfirmPassword()))){
            
            error.addMessage(new MessageBuilder()
                    .error()
                    .source("confirmPassword")
                    .defaultText("Password does not match the confirm password!")
                    .build());
            
            transitionValue = "failure";
        }
        
        if(userService.getUserByEmail(user.getEmail()) != null){
            error.addMessage(new MessageBuilder()
                    .error()
                    .source("email")
                    .defaultText("Email address is already used!")
                    .build());
            
            transitionValue = "failure";
        }
        
        return transitionValue;
        
    }
    
    public String saveAll(RegisterModel registerModel){
        
        String transitionValue = "success";
        
        //fetch the user
        
        User user = registerModel.getUser();
        
        if(user.getRole().equals("USER")){
            
            Cart cart = new Cart();
            cart.setUser(user);
            user.setCart(cart);
            
        }
        
        //encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       
        //save the user
        
        userService.addUser(user);
        
        //get the address
        
        Address billing = registerModel.getBilling();
        
        billing.setUserId(user.getId());
        billing.setBilling(true);
        
        //save the address
        userService.addAddress(billing);
        
        return transitionValue;
        
    }
    
}
