
package by.bntu.poisit.spring.sprshop.service.impl;

import by.bntu.poisit.spring.sprshop.dao.UserDAO;
import by.bntu.poisit.spring.sprshop.entity.Address;
import by.bntu.poisit.spring.sprshop.entity.User;
import by.bntu.poisit.spring.sprshop.handler.MailHandler;
import by.bntu.poisit.spring.sprshop.service.UserService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static by.bntu.poisit.spring.sprshop.constant.MessageMailConstant.*;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private MailHandler mailHandler;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public boolean addUser(User user) {
       return userDAO.addUser(user);
    }
    
    @Override
    @Transactional
    public boolean updateUser(User user) {
       return userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public boolean addAddress(Address address) {
        return userDAO.addAddress(address);
    }

    @Override
    @Transactional
    public User getUserByEmail(String email) {
       return userDAO.getUserByEmail(email);
    }

    @Override
    @Transactional
    public Address getBillingAddress(int userId) {
        return userDAO.getBillingAddress(userId);
    }

    @Override
    @Transactional
    public List<Address> listShippingAddresses(int userId) {
        return userDAO.listShippingAddresses(userId);
    }

    @Override
    @Transactional
    public boolean updateAddress(Address address) {
        return userDAO.updateAddress(address);
    }

    @Override
    @Transactional
    public Address getAddress(int addressId) {
        return userDAO.getAddress(addressId);
    }

    @Override
    @Transactional
    public boolean existsUserByEmail(String email) {
        return userDAO.existsUserByEmail(email);
    }

    @Override
    @Transactional
    public void updateUserPassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        updateUser(user);
        mailHandler.sendMessage(user.getEmail(), MESSAGE_CHANGE_PASSWORD_SUBJECT, MESSAGE_CHANGE_PASSWORD_TEXT);
    }

}
