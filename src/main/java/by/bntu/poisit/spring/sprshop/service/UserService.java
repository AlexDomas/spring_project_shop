
package by.bntu.poisit.spring.sprshop.service;

import by.bntu.poisit.spring.sprshop.entity.Address;
import by.bntu.poisit.spring.sprshop.entity.Cart;
import by.bntu.poisit.spring.sprshop.entity.User;


public interface UserService {
    
    boolean addUser(User user);
    
    boolean addAddress(Address address);
    
    boolean updateCart(Cart cart);
    
    User getUserByEmail(String email);
    
}
