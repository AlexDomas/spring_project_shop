package by.bntu.poisit.spring.sprshop.dao.impl;

import by.bntu.poisit.spring.sprshop.dao.UserDAO;
import by.bntu.poisit.spring.sprshop.entity.Address;
import by.bntu.poisit.spring.sprshop.entity.Cart;
import by.bntu.poisit.spring.sprshop.entity.User;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addUser(User user) {
        try {
            sessionFactory.getCurrentSession().persist(user);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addAddress(Address address) {
        try {
            sessionFactory.getCurrentSession().persist(address);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCart(Cart cart) {
        try {
            sessionFactory.getCurrentSession().update(cart);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        String selectQuery = "FROM User WHERE email = :email";

        try {
            return sessionFactory.getCurrentSession()
                    .createQuery(selectQuery, User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public Address getBillingAddress(User user) {
        
        String selectQuery = "FROM Address WHERE user =: user AND billing =: billing";
        
        try{
            
            return sessionFactory.getCurrentSession()
                    .createQuery(selectQuery, Address.class)
                    .setParameter("user", user)
                    .setParameter("billing", true)
                    .getSingleResult();
            
        }
        catch(Exception ex){
            
            ex.printStackTrace();
            return null;
            
        }
        
        
    }

    @Override
    public List<Address> listShippingAddresses(User user) {
        String selectQuery = "FROM Address WHERE user =: user AND shipping =: shipping";
        
        try{
            
            return sessionFactory.getCurrentSession()
                    .createQuery(selectQuery, Address.class)
                    .setParameter("user", user)
                    .setParameter("shipping", true)
                    .getResultList();
            
        }
        catch(Exception ex){
            
            ex.printStackTrace();
            return null;
            
        }
    }

}
