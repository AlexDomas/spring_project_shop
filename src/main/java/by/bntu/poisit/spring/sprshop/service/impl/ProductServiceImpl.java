
package by.bntu.poisit.spring.sprshop.service.impl;

import by.bntu.poisit.spring.sprshop.dao.ProductDAO;
import by.bntu.poisit.spring.sprshop.dto.Product;
import by.bntu.poisit.spring.sprshop.service.ProductService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDAO productDAO;
    
    @Override
    @Transactional
    public List<Product> listActiveProducts() {
        return productDAO.listActiveProducts();
    }

    @Override
    @Transactional
    public List<Product> listActiveProductsByCategory(int categoryId) {
        return productDAO.listActiveProductsByCategory(categoryId);
    }

    @Override
    @Transactional
    public List<Product> getLatestActiveProducts(int count) {
        return productDAO.getLatestActiveProducts(count);
    }

    @Override
    @Transactional
    public List<Product> list() {
        return productDAO.list();
    }

    @Override
    @Transactional
    public Product get(int id) {
        return productDAO.get(id);
    }

    @Override
    @Transactional
    public boolean add(Product product) {
        return productDAO.add(product);
    }

    @Override
    @Transactional
    public boolean update(Product product) {
        return productDAO.update(product);
    }

    @Override
    @Transactional
    public boolean delete(Product product) {
        return productDAO.delete(product);
    }
    
    
    
}
