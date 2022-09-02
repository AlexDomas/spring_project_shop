package by.bntu.poisit.spring.sprshop.service.impl;

import by.bntu.poisit.spring.sprshop.entity.Cart;
import by.bntu.poisit.spring.sprshop.entity.CartLine;
import by.bntu.poisit.spring.sprshop.entity.Product;
import by.bntu.poisit.spring.sprshop.dto.UserProfileDataDto;
import by.bntu.poisit.spring.sprshop.service.CartLineService;
import by.bntu.poisit.spring.sprshop.service.CartService;
import by.bntu.poisit.spring.sprshop.service.ProductService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartLineService cartLineService;
    
    @Autowired
    private ProductService productService;

    @Autowired
    private HttpSession httpSession;

    //returns the cart of the user who has logged in
    private Cart getCart() {
        return ((UserProfileDataDto) httpSession.getAttribute("userProfileDataDto")).getCart();
    }

    //returns the entire cartlines
    public List<CartLine> getCartLines() {
        return cartLineService.list(this.getCart().getId());
    }

    @Override
    public String updateCartLine(int cartLineId, int count) {
        CartLine cartLine = cartLineService.get(cartLineId);

        if (cartLine == null) {
            return "result=error";
        } else {
            Product product = cartLine.getProduct();
            double oldTotal = cartLine.getTotal();
            //checking if the product is available
            if (product.getQuantity() < count) {
                return "result=unavailable";
            }
            cartLine.setProductCount(count);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setTotal(product.getUnitPrice() * count);

            cartLineService.update(cartLine);

            Cart cart = this.getCart();
            cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
            cartLineService.updateCart(cart);

            return "result=updated";
        }
    }

    @Override
    public String deleteCartLine(int cartLineId) {
        
        CartLine cartLine = cartLineService.get(cartLineId);
        
        if(cartLine == null){
            return "result=error";
        }
        else{
            //update the cart
            Cart cart = this.getCart();
            cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
            cart.setCartLines(cart.getCartLines() - 1);
            cartLineService.updateCart(cart);
            //remove the cart line
            cartLineService.delete(cartLine);
            
            return "result=deleted";
        }
        
    }

    @Override
    public String addCartLine(int productId) {
        
        String response = null;
        
        Cart cart = this.getCart();
        
        CartLine cartLine = cartLineService.getByCartAndProduct(cart.getId(), productId);
        
        if(cartLine == null){
            // add a new cartLine
            cartLine = new CartLine();
            //fetch the product
            Product product = productService.get(productId);
            
            cartLine.setCartId(cart.getId());
            cartLine.setProduct(product);
            cartLine.setBuyingPrice(product.getUnitPrice());
            cartLine.setProductCount(1);
            cartLine.setTotal(product.getUnitPrice());
            cartLine.setAvailable(true);
            
            cartLineService.add(cartLine);
            
            cart.setCartLines(cart.getCartLines() + 1);
            cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
            
            cartLineService.updateCart(cart);
            
            response = "result=added";
        }
        else{
            //check if the cartLine has reached the maximum count
            if(cartLine.getProductCount() < 10){
                response = this.updateCartLine(cartLine.getId(), cartLine.getProductCount() + 1);
            }
            else{
                response = "result=maximum";
            }
            
        }
        
        return response;
    }
    
    @Override
    public String validateCartLine() {
		Cart cart = this.getCart();
		List<CartLine> cartLines = cartLineService.list(cart.getId());
		double grandTotal = 0.0;
		int lineCount = 0;
		String response = "result=success";
		boolean changed = false;
		Product product = null;
		for(CartLine cartLine : cartLines) {					
			product = cartLine.getProduct();
			changed = false;
			// check if the product is active or not
			// if it is not active make the availability of cartLine as false
			if((!product.isActive() && product.getQuantity() == 0) && cartLine.isAvailable()) {
				cartLine.setAvailable(false);
				changed = true;
			}			
			// check if the cartLine is not available
			// check whether the product is active and has at least one quantity available
			if((product.isActive() && product.getQuantity() > 0) && !(cartLine.isAvailable())) {
					cartLine.setAvailable(true);
					changed = true;
			}
			
			// check if the buying price of product has been changed
			if(cartLine.getBuyingPrice() != product.getUnitPrice()) {
				// set the buying price to the new price
				cartLine.setBuyingPrice(product.getUnitPrice());
				// calculate and set the new total
				cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
				changed = true;				
			}
			
			// check if that much quantity of product is available or not
			if(cartLine.getProductCount() > product.getQuantity()) {
				cartLine.setProductCount(product.getQuantity());										
				cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
				changed = true;
				
			}
			
			// changes has happened
			if(changed) {				
				//update the cartLine
				cartLineService.update(cartLine);
				// set the result as modified
				response = "result=modified";
			}
			
			grandTotal += cartLine.getTotal();
			lineCount++;
		}
		
		cart.setCartLines(lineCount++);
		cart.setGrandTotal(grandTotal);
		cartLineService.updateCart(cart);

		return response;
	}	

}
