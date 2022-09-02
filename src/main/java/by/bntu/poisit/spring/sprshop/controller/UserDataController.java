package by.bntu.poisit.spring.sprshop.controller;

import by.bntu.poisit.spring.sprshop.dto.ChangePasswordDto;
import by.bntu.poisit.spring.sprshop.dto.UserProfileDataDto;
import by.bntu.poisit.spring.sprshop.entity.User;
import by.bntu.poisit.spring.sprshop.service.UserService;
import by.bntu.poisit.spring.sprshop.util.UserProfileDataMapper;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import by.bntu.poisit.spring.sprshop.validator.group.ChangeProfileInfoGroup;

@Controller
public class UserDataController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserProfileDataMapper userProfileDataMapper;

    @GetMapping(value = "/edit_profile")
    public String editProfile(Model model, Principal principal) {
        model.addAttribute("title", "Edit Profile");
        User user = userService.getUserByEmail(principal.getName());
        UserProfileDataDto userProfileDataDto = userProfileDataMapper.createUserDto(user);
        model.addAttribute("userProfileDataDto", userProfileDataDto);
        return "editProfile";
    }

    @PostMapping(value = "/edit_profile")
    public String editProfileAction(Model model, @ModelAttribute("userProfileDataDto") @Validated({ChangeProfileInfoGroup.class}) UserProfileDataDto userProfileDataDto, BindingResult bindingResult, Principal principal) {
        if (!bindingResult.hasErrors()) {
            User user = userService.getUserByEmail(principal.getName());
            userProfileDataMapper.createUserEntity(user, userProfileDataDto);
            userService.updateUser(user);
            model.addAttribute("success", "Your profile was updated!");
            return "editProfile";
        }
        return "editProfile";
    }

    @GetMapping(value = "/change_password")
    public String changePassword(Model model) {
        model.addAttribute("title", "Change Password");
        ChangePasswordDto changePasswordDto = new ChangePasswordDto();
        model.addAttribute("changePasswordDto", changePasswordDto);
        return "changePassword";
    }

    @PostMapping(value = "/change_password")
    public String changePasswordAction(Model model, @ModelAttribute("changePasswordDto") @Validated ChangePasswordDto changePasswordDto, BindingResult bindingResult, Principal principal) {
        if (!bindingResult.hasErrors()) {
            User user = userService.getUserByEmail(principal.getName());
            userService.updateUserPassword(user, changePasswordDto.getNewPassword());
            model.addAttribute("success", "Your password was updated!");
            return "changePassword";
        }
        return "changePassword";
    }

}
