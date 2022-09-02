package by.bntu.poisit.spring.sprshop.service;

import by.bntu.poisit.spring.sprshop.entity.Product;
import java.util.List;

public interface ProductService extends GeneralService<Product>{
    
    List<Product> listActiveProducts();
    List<Product> listActiveProductsByCategory(int categoryId);
    List<Product> getLatestActiveProducts(int count);
    List<Product> getProductsByParam(String param, int count);
    
    boolean deleteProduct(int id);
    
}
