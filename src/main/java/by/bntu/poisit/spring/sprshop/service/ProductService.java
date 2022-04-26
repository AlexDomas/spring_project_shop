/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bntu.poisit.spring.sprshop.service;

import by.bntu.poisit.spring.sprshop.entity.Product;
import java.util.List;


public interface ProductService extends GeneralService<Product>{
    
    List<Product> listActiveProducts();
    List<Product> listActiveProductsByCategory(int categoryId);
    List<Product> getLatestActiveProducts(int count);
    
}
