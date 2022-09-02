
package by.bntu.poisit.spring.sprshop.service;

import by.bntu.poisit.spring.sprshop.entity.Address;
import by.bntu.poisit.spring.sprshop.entity.OrderDetail;
import by.bntu.poisit.spring.sprshop.entity.User;
import java.util.List;


public interface UserService {
    
    boolean addUser(User user);
    
    boolean updateUser(User user);
    
    boolean addAddress(Address address);
    
    User getUserByEmail(String email);
    
    Address getBillingAddress(int userId);
    
    List<Address> listShippingAddresses(int userId);
    
    boolean updateAddress(Address address);
    
    Address getAddress(int addressId);
    
    boolean existsUserByEmail(String email);
    
    void updateUserPassword(User user, String newPassword);
    
}
