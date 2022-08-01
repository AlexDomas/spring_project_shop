
package by.bntu.poisit.spring.sprshop.service;

import by.bntu.poisit.spring.sprshop.dto.Address;
import by.bntu.poisit.spring.sprshop.dto.Cart;
import by.bntu.poisit.spring.sprshop.dto.User;
import java.util.List;


public interface UserService {
    
    boolean addUser(User user);
    
    boolean addAddress(Address address);
    
    boolean updateCart(Cart cart);
    
    User getUserByEmail(String email);
    
    Address getBillingAddress(User user);
    
    List<Address> listShippingAddresses(User user);
    
}
