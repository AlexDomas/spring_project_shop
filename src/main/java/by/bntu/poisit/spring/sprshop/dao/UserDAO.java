
package by.bntu.poisit.spring.sprshop.dao;

import by.bntu.poisit.spring.sprshop.entity.Address;
import by.bntu.poisit.spring.sprshop.entity.Cart;
import by.bntu.poisit.spring.sprshop.entity.User;
import java.util.List;


public interface UserDAO {
    
    boolean addUser(User user);
    
    User getUserByEmail(String email);
    
    boolean addAddress(Address address);
    
    Address getBillingAddress(User user);
    
    List<Address> listShippingAddresses(User user);
    
    boolean updateCart(Cart cart);
    
}
