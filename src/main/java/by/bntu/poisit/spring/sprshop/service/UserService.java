
package by.bntu.poisit.spring.sprshop.service;

import by.bntu.poisit.spring.sprshop.entity.Address;
import by.bntu.poisit.spring.sprshop.entity.Cart;
import by.bntu.poisit.spring.sprshop.entity.User;
import java.util.List;


public interface UserService {
    
    boolean addUser(User user);
    
    boolean addAddress(Address address);
    
    boolean updateCart(Cart cart);
    
    User getUserByEmail(String email);
    
    Address getBillingAddress(User user);
    
    List<Address> listShippingAddresses(User user);
    
}
