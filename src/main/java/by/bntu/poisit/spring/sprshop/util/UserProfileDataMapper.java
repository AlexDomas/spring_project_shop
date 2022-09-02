package by.bntu.poisit.spring.sprshop.util;

import by.bntu.poisit.spring.sprshop.dto.UserProfileDataDto;
import by.bntu.poisit.spring.sprshop.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserProfileDataMapper {

    public UserProfileDataDto createUserDto(User user) {
        UserProfileDataDto userDto = new UserProfileDataDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhoneNumber(user.getContactNumber());
        if(userDto.getRole().equals("USER")){
            userDto.setCart(user.getCart());
        }
        return userDto;
    }

    public void createUserEntity(User user, UserProfileDataDto userProfileDataDto) {
        user.setEmail(userProfileDataDto.getEmail());
        user.setFirstName(userProfileDataDto.getFirstName());
        user.setLastName(userProfileDataDto.getLastName());
        user.setContactNumber(userProfileDataDto.getPhoneNumber());
    }

}
