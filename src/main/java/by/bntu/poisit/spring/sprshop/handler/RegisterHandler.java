package by.bntu.poisit.spring.sprshop.handler;

import by.bntu.poisit.spring.sprshop.entity.Address;
import by.bntu.poisit.spring.sprshop.entity.Cart;
import by.bntu.poisit.spring.sprshop.entity.User;
import by.bntu.poisit.spring.sprshop.dto.RegisterDto;
import by.bntu.poisit.spring.sprshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import static by.bntu.poisit.spring.sprshop.constant.MessageMailConstant.*;

@Component
public class RegisterHandler {
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private MailHandler mailHandler;
    
    public RegisterDto init(){
        
        return new RegisterDto();
        
    }
    
    public void addUser(RegisterDto registerDto, User user){
        
        registerDto.setUser(user);
        
    }
    
    public void addBilling(RegisterDto registerDto, Address billing){
        
        registerDto.setBilling(billing);
        
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
    
    public String saveAll(RegisterDto registerDto){
        
        String transitionValue = "success";
        
        //fetch the user
        
        User user = registerDto.getUser();
        
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
        
        Address billing = registerDto.getBilling();
        
        billing.setUserId(user.getId());
        billing.setBilling(true);
        
        //save the address
        userService.addAddress(billing);
        
        mailHandler.sendMessage(user.getEmail(), MESSAGE_REGISTRATION_SUBJECT, MESSAGE_REGISTRATION_TEXT);
        
        return transitionValue;
        
    }
    
}
