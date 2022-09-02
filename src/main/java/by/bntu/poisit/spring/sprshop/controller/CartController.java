package by.bntu.poisit.spring.sprshop.controller;

import by.bntu.poisit.spring.sprshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static by.bntu.poisit.spring.sprshop.constant.MessageConstant.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/show")
    public String showCart(Model model, @RequestParam(name = "result", required = false) String result) {

        if (result != null) {
            switch (result) {
                case "updated":
                    model.addAttribute("message", MESSAGE_CARTLINE_SUCCESS_UPDATE);
                    break;
                case "added":
                    model.addAttribute("message", MESSAGE_CARTLINE_SUCCESS_ADD);
                    break;
                case "deleted":
                    model.addAttribute("message", MESSAGE_CARTLINE_SUCCESS_DELETE);
                    break;
                case "maximum":
                    model.addAttribute("message", MESSAGE_CARTLINE_MAXIMUM_COUNT);
                    break;
                case "unavailable":
                    model.addAttribute("message", MESSAGE_PRODUCT_COUNT_IS_NOT_AVAILABLE);
                    break;
                case "error":
                    model.addAttribute("message", MESSAGE_ERROR_CARTLINE);
                    break;
            }
        }

        model.addAttribute("title", "User Cart");
        model.addAttribute("userClickShowCart", true);
        model.addAttribute("cartLines", cartService.getCartLines());

        return "page";
    }

    @RequestMapping("/{cartLineId}/update")
    public String updateCart(@PathVariable int cartLineId, @RequestParam int count) {

        String response = cartService.updateCartLine(cartLineId, count);

        return "redirect:/cart/show?" + response;
    }

    @RequestMapping("/{cartLineId}/delete")
    public String deleteCartLineFromCart(@PathVariable int cartLineId) {

        String response = cartService.deleteCartLine(cartLineId);

        return "redirect:/cart/show?" + response;
    }

    @RequestMapping("/add/{productId}/product")
    public String addProductToCart(@PathVariable int productId) {

        String response = cartService.addCartLine(productId);

        return "redirect:/cart/show?" + response;
    }

    @RequestMapping("/validate")
    public String validateCart() {
        String response = cartService.validateCartLine();
        if (!response.equals("result=success")) {
            return "redirect:/cart/show?" + response;
        } else {
            return "redirect:/cart/checkout";
        }
    }

}
