package by.bntu.poisit.spring.sprshop.dao.impl;

import by.bntu.poisit.spring.sprshop.dao.CartLineDAO;
import by.bntu.poisit.spring.sprshop.dto.CartLine;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static by.bntu.poisit.spring.sprshop.constants.SQLContants.*;

@Repository("cartLineDAO")
public class CartLineDAOImpl implements CartLineDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CartLine> list(int cartId) {
        return sessionFactory.getCurrentSession()
                .createQuery(GET_CARTLINE_BY_CART_ID, CartLine.class)
                .setParameter("cartId", cartId).getResultList();
    }

    @Override
    public List<CartLine> listAvailable(int cartId) {
        return sessionFactory.getCurrentSession()
                .createQuery(GET_CARTLINE_BY_CART_ID_AND_AVAILABILITY, CartLine.class)
                .setParameter("cartId", cartId)
                .setParameter("available", true)
                .getResultList();
    }

    @Override
    public CartLine getByCartAndProduct(int cartId, int productId) {
        try {
            return sessionFactory.getCurrentSession()
                    .createQuery(GET_CARTLINE_BY_CART_AND_PRODUCT, CartLine.class)
                    .setParameter("cartId", cartId)
                    .setParameter("productId", productId)
                    .getSingleResult();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public CartLine get(int id) {
        return sessionFactory
                .getCurrentSession()
                .get(CartLine.class, id);
    }

    @Override
    public boolean add(CartLine cartLine) {
        try {
            sessionFactory
                    .getCurrentSession()
                    .persist(cartLine);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(CartLine cartLine) {
        try {
            sessionFactory
                    .getCurrentSession()
                    .update(cartLine);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(CartLine cartLine) {
        try {
            sessionFactory
                    .getCurrentSession()
                    .delete(cartLine);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<CartLine> list() {
        return sessionFactory
                .getCurrentSession()
                .createQuery(SELECT_ALL_CARTLINES, CartLine.class)
                .getResultList();
    }

}
