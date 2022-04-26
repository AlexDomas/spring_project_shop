
package by.bntu.poisit.spring.sprshop.controller;

import by.bntu.poisit.spring.sprshop.entity.Product;
import by.bntu.poisit.spring.sprshop.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/json/data")
public class JsonDataController {
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping("/all/products")
    @ResponseBody
    public List<Product> getAllProducts(){
        
        return productService.listActiveProducts();
        
    }
    
    @RequestMapping("/admin/all/products")
    @ResponseBody
    public List<Product> getAllProductsForAdmin(){
        
        return productService.list();
        
    }
    
    @RequestMapping("/category/{id}/products")
    @ResponseBody
    public List<Product> getAllProductsByCategory(@PathVariable int id){
        
        return productService.listActiveProductsByCategory(id);
        
    }
    
}
