package by.bntu.poisit.spring.sprshop.controller;

import by.bntu.poisit.spring.sprshop.entity.Category;
import by.bntu.poisit.spring.sprshop.entity.Product;
import by.bntu.poisit.spring.sprshop.service.CategoryService;
import by.bntu.poisit.spring.sprshop.service.ProductService;
import by.bntu.poisit.spring.sprshop.util.FileUploadUtil;
import by.bntu.poisit.spring.sprshop.util.ProductValidator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String showManageProducts(@RequestParam(name = "operation", required = false) String operation, Model model) {

        model.addAttribute("userClickManageProducts", true);
        model.addAttribute("title", "Manage Products");

        Product nProduct = new Product();

        nProduct.setSupplierId(1);
        nProduct.setActive(true);

        model.addAttribute("product", nProduct);

        if (operation != null) {

            if (operation.equals("product")) {

                model.addAttribute("message", "Product Submitted Successfully!");

            }
            else if(operation.equals("category")){
                 model.addAttribute("message", "Category Submitted Successfully!");
            }

        }

        return "page";
    }

    @RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
    public String showEditProducts(@PathVariable int id, Model model) {

        model.addAttribute("userClickManageProducts", true);
        model.addAttribute("title", "Manage Products");

        Product nProduct = productService.get(id);

        model.addAttribute("product", nProduct);

        return "page";
    }

    //handling product submission
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,
            BindingResult results, Model model, HttpServletRequest request) {

        if (mProduct.getId() == 0) {
            new ProductValidator().validate(mProduct, results);
        }
        else{
            if(!mProduct.getFile().getOriginalFilename().equals("")){
                new ProductValidator().validate(mProduct, results);
            }
        }

        //check if there are any errors
        if (results.hasErrors()) {
            model.addAttribute("userClickManageProducts", true);
            model.addAttribute("title", "Manage Products");
            model.addAttribute("message", "Validation failed for Product Submission!");

            return "page";
        }

        logger.info(mProduct.toString());

        //create a new product record 
        if (mProduct.getId() == 0) {
            productService.add(mProduct);
        } else {
            productService.update(mProduct);
        }

        if (!mProduct.getFile().getOriginalFilename().equals("")) {
            FileUploadUtil.uploadFile(request, mProduct.getFile(), mProduct.getCode());
        }

        return "redirect:/manage/products?operation=product";
    }

    @RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
    @ResponseBody
    public String handleProductActivation(@PathVariable int id) {

        Product product = productService.get(id);
        boolean isActive = product.isActive();

        product.setActive(!product.isActive());
        productService.update(product);

        return (isActive) ? "You have succesfully deactivated the product with id " + product.getId()
                : "You have succesfully activated the product with id " + product.getId();
    }
    
    
    //to handle category submission
    @RequestMapping(value="/category", method=RequestMethod.POST)
    public String handleCategorySubmission(@ModelAttribute Category category){
        
        categoryService.add(category);
        
        return "redirect:/manage/products?operation=category";
        
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {

        return categoryService.list();
    }
    
    @ModelAttribute("category")
    public Category getCategory(){
        return new Category();
    }

}
