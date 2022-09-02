package by.bntu.poisit.spring.sprshop.controller;

import by.bntu.poisit.spring.sprshop.entity.User;
import by.bntu.poisit.spring.sprshop.dto.UserProfileDataDto;
import by.bntu.poisit.spring.sprshop.service.UserService;
import by.bntu.poisit.spring.sprshop.util.UserProfileDataMapper;
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
    private UserProfileDataMapper userMapper;

    @ModelAttribute("userProfileDataDto")
    public UserProfileDataDto getUserDto() {
        if (session.getAttribute("userProfileDataDto") == null) {
            //add the user model
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.getUserByEmail(authentication.getName());
            if (user != null) {
                //create a new UserDto object to pass the user details
                UserProfileDataDto userDto = userMapper.createUserDto(user);
                session.setAttribute("userProfileDataDto", userDto);
                return userDto;
            }
        }
        return (UserProfileDataDto) session.getAttribute("userProfileDataDto");
    }

}
