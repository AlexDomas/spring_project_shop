package by.bntu.poisit.spring.sprshop.controller;

import by.bntu.poisit.spring.sprshop.entity.Product;
import by.bntu.poisit.spring.sprshop.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/data")
public class ProductDataController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.listActiveProducts();
    }

    @GetMapping("/admin/all/products")
    @ResponseBody
    public List<Product> getAllProductsForAdmin() {
        return productService.list();
    }

    @GetMapping("/category/{id}/products")
    @ResponseBody
    public List<Product> getAllProductsByCategory(@PathVariable int id) {
        return productService.listActiveProductsByCategory(id);
    }

    @GetMapping("/mv/products")
    @ResponseBody
    public List<Product> getMostViewedProducts() {
        return productService.getProductsByParam("views", 5);
    }

    @RequestMapping("/mp/products")
    @ResponseBody
    public List<Product> getMostPurchasedProducts() {
        return productService.getProductsByParam("purchases", 5);
    }

}
