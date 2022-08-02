package by.bntu.poisit.spring.sprshop.dao.impl;

import static by.bntu.poisit.spring.sprshop.constants.SQLContants.*;
import by.bntu.poisit.spring.sprshop.dao.ProductDAO;
import by.bntu.poisit.spring.sprshop.dto.Product;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Product> list() {
        return sessionFactory
                .getCurrentSession()
                .createQuery(SELECT_ALL_PRODUCTS, Product.class)
                .getResultList();
        
    }
    
    @Override
    public Product get(int id) {
        
        try {
            return sessionFactory
                    .getCurrentSession()
                    .get(Product.class, Integer.valueOf(id));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
        
    }
    
    @Override
    public boolean add(Product product) {
        try {
            sessionFactory
                    .getCurrentSession()
                    .persist(product);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
        
    }
    
    @Override
    public boolean update(Product product) {
        try {
            sessionFactory
                    .getCurrentSession()
                    .update(product);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean delete(Product product) {
        try {
            product.setActive(false);
            return this.update(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public List<Product> listActiveProducts() {
        
        return sessionFactory
                .getCurrentSession()
                .createQuery(SELECT_ACTIVE_PRODUCTS, Product.class)
                .setParameter("active", true)
                .getResultList();
        
    }
    
    @Override
    public List<Product> listActiveProductsByCategory(int categoryId) {
        
        return sessionFactory
                .getCurrentSession()
                .createQuery(SELECT_ACTIVE_PRODUCTS_BY_CATEGORY, Product.class)
                .setParameter("active", true)
                .setParameter("categoryId", categoryId)
                .getResultList();
        
    }
    
    @Override
    public List<Product> getLatestActiveProducts(int count) {
        
        return sessionFactory
                .getCurrentSession()
                .createQuery(GET_LATEST_ACTIVE_PRODUCTS, Product.class)
                .setParameter("active", true)
                .setFirstResult(0)
                .setMaxResults(count)
                .getResultList();
        
    }
    
}
