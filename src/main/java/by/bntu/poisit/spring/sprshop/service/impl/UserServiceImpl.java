
package by.bntu.poisit.spring.sprshop.service.impl;

import by.bntu.poisit.spring.sprshop.dao.UserDAO;
import by.bntu.poisit.spring.sprshop.entity.Address;
import by.bntu.poisit.spring.sprshop.entity.Cart;
import by.bntu.poisit.spring.sprshop.entity.User;
import by.bntu.poisit.spring.sprshop.service.UserService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public boolean addUser(User user) {
       return userDAO.addUser(user);
    }

    @Override
    @Transactional
    public boolean addAddress(Address address) {
        return userDAO.addAddress(address);
    }

    @Override
    @Transactional
    public boolean updateCart(Cart cart) {
       return userDAO.updateCart(cart);
    }

    @Override
    public User getUserByEmail(String email) {
       return userDAO.getUserByEmail(email);
    }

    @Override
    public Address getBillingAddress(User user) {
        return userDAO.getBillingAddress(user);
    }

    @Override
    public List<Address> listShippingAddresses(User user) {
        return userDAO.listShippingAddresses(user);
    }
    
    
    
}
