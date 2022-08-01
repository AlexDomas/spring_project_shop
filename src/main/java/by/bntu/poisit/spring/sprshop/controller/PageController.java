package by.bntu.poisit.spring.sprshop.controller;

import by.bntu.poisit.spring.sprshop.dto.Category;
import by.bntu.poisit.spring.sprshop.dto.Product;
import by.bntu.poisit.spring.sprshop.exception.ProductNotFoundException;
import by.bntu.poisit.spring.sprshop.service.CategoryService;
import by.bntu.poisit.spring.sprshop.service.ProductService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/", "/home", "/index"})
    public String home(Model model) {

        model.addAttribute("title", "Home");

        logger.info("Inside PageController home method");
        logger.debug("Inside PageController home method - DEBUG");

        model.addAttribute("userClickHome", true);
        return "page";

    }

    @RequestMapping(value = "/about")
    public String about(Model model) {

        model.addAttribute("title", "About Us");
        model.addAttribute("userClickAbout", true);
        return "page";

    }

    @RequestMapping(value = "/contact")
    public String contact(Model model) {

        model.addAttribute("title", "Contact");
        model.addAttribute("userClickContact", true);
        return "page";

    }

    @RequestMapping(value = "/popularProducts")
    public String popularProducts(Model model) {
        model.addAttribute("title", "PopularProducts");
        model.addAttribute("categories", categoryService.list());
        model.addAttribute("userClickPopularProducts", true);
        return "page";

    }

    @RequestMapping(value = "/news")
    public String news(Model model) {

        model.addAttribute("title", "News");
        model.addAttribute("userClickNews", true);
        return "page";

    }

    @RequestMapping(value = "/reviews")
    public String reviews(Model model) {
        model.addAttribute("title", "Reviews");
        model.addAttribute("userClickReviews", true);
        return "page";

    }

    @RequestMapping(value = "/show/all/products")
    public String showAllProducts(Model model) {

        model.addAttribute("title", "All Products");

        model.addAttribute("categories", categoryService.list());

        model.addAttribute("userClickAllProducts", true);
        
        return "page";

    }

    @RequestMapping(value = "/show/category/{id}/products")
    public String showCategoryProducts(@PathVariable("id") int id, Model model) {

        // categoryDAO to fetch a single category
        Category category = null;

        category = categoryService.get(id);

        model.addAttribute("title", category.getName());

        //passing the list of categories
        model.addAttribute("categories", categoryService.list());

        // passing the single category object
        model.addAttribute("category", category);

        model.addAttribute("userClickCategoryProducts", true);

        return "page";

    }

    //Viewing a single product
    @RequestMapping(value = "/show/{id}/product")
    public String showSingleProduct(@PathVariable int id, Model model) throws ProductNotFoundException {

        Product product = productService.get(id);

        if (product == null) {
            throw new ProductNotFoundException();
        }

        //update the view count
        product.setViews(product.getViews() + 1);
        productService.update(product);

        model.addAttribute("title", product.getName());
        model.addAttribute("product", product);

        model.addAttribute("userClickShowProduct", true);

        return "page";

    }

    /* having similar mapping to our flow id*/
    @RequestMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("title", "Register");
        return "page";
    }
    
    /*Login*/
    @RequestMapping(value = "/login")
    public String login(Model model, 
            @RequestParam(name="error", required = false)String error,
            @RequestParam(name="logout", required = false)String logout) {
        
        if(error != null){
            model.addAttribute("message", "Invalid Username or Password!");
        }
        
        if(logout != null){
            model.addAttribute("logout", "User has successfully logged out!");
        }
        
        model.addAttribute("title", "Login");
        
        return "login";
    }

     /* access denied page */
    @RequestMapping(value = "/access-denied")
    public String accessDenied(Model model) {
        model.addAttribute("title", "403 - Access Denied.");
        model.addAttribute("errorTitle", "Aha! Caught You.");
        model.addAttribute("errorDescription", "You are not authorized to view this page!");
        return "error";
    }
    
    @RequestMapping(value = "/permorm-logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        //first we are going to fetch the authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        
        return "redirect:/login?logout";
    }

}
