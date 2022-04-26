
package by.bntu.poisit.spring.sprshop.dao;

import by.bntu.poisit.spring.sprshop.entity.Address;
import by.bntu.poisit.spring.sprshop.entity.Cart;
import by.bntu.poisit.spring.sprshop.entity.User;


public interface UserDAO {
    
    boolean addUser(User user);
    
    User getUserByEmail(String email);
    
    boolean addAddress(Address address);
    
    boolean updateCart(Cart cart);
    
}
