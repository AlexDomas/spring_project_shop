
package by.bntu.poisit.spring.sprshop.dao;

import by.bntu.poisit.spring.sprshop.entity.Product;
import java.util.List;


public interface ProductDAO extends GeneralDAO<Product>{
    
    List<Product> listActiveProducts();
    List<Product> listActiveProductsByCategory(int categoryId);
    List<Product> getLatestActiveProducts(int count);
    List<Product> getProductsByParam(String param, int count);
    
    boolean deleteProduct(int id);
    
}
