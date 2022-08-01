package by.bntu.poisit.spring.sprshop.controller;

import by.bntu.poisit.spring.sprshop.dto.User;
import by.bntu.poisit.spring.sprshop.model.UserModel;
import by.bntu.poisit.spring.sprshop.service.UserService;
import by.bntu.poisit.spring.sprshop.util.UserMapper;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalController {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @ModelAttribute("userModel")
    public UserModel getUserModel() {
        if (session.getAttribute("userModel") == null) {
            //add the user model
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.getUserByEmail(authentication.getName());
            if (user != null) {
                //create a new UserModel object to pass the user details
                UserModel userModel = userMapper.toUserModel(user);
                session.setAttribute("userModel", userModel);
                return userModel;
            }
        }
        return (UserModel) session.getAttribute("userModel");
    }

}
