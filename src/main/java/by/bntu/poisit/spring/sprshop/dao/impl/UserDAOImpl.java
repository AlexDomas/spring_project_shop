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

import static by.bntu.poisit.spring.sprshop.constant.SQLConstant.*;

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
    public boolean updateUser(User user) {
        try {
            sessionFactory.getCurrentSession().update(user);
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
    public User getUserByEmail(String email) {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery(GET_USER_BY_EMAIL, User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }

    }
    
    @Override
    public boolean existsUserByEmail(String email){
        try{
            sessionFactory.getCurrentSession()
                    .createQuery(GET_USER_BY_EMAIL, User.class).getSingleResult();
            return false;
        }
        catch(Exception ex){
            return true;
        }
    }

    @Override
    public Address getBillingAddress(int userId) {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery(GET_ADDRESS_BY_USER_ID_AND_BILLING, Address.class)
                    .setParameter("userId", userId)
                    .setParameter("billing", true)
                    .getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Address> listShippingAddresses(int userId) {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery(GET_LIST_OF_ADDRESSES_BY_USER_ID_AND_SHIPPING, Address.class)
                    .setParameter("userId", userId)
                    .setParameter("shipping", true)
                    .getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateAddress(Address address) {
        try {
            sessionFactory.getCurrentSession().update(address);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Address getAddress(int addressId) {
        try {
            return sessionFactory.getCurrentSession().get(Address.class, addressId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
