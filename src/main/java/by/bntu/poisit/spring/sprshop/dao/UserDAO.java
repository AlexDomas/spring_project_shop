
package by.bntu.poisit.spring.sprshop.dao;

import by.bntu.poisit.spring.sprshop.entity.Address;
import by.bntu.poisit.spring.sprshop.entity.User;
import java.util.List;


public interface UserDAO {
    
    boolean addUser(User user);
    
     boolean updateUser(User user);
    
    User getUserByEmail(String email);
    
    boolean addAddress(Address address);
    
    boolean updateAddress(Address address);
    
    Address getBillingAddress(int userId);
    
    Address getAddress(int addressId);
    
    List<Address> listShippingAddresses(int userId);
    
    boolean existsUserByEmail(String email);
    
}
