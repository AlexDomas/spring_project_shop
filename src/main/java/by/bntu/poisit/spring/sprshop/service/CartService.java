package by.bntu.poisit.spring.sprshop.service;

import by.bntu.poisit.spring.sprshop.entity.CartLine;
import java.util.List;

public interface CartService {
    
    public List<CartLine> getCartLines();
    
    public String updateCartLine(int cartLineId, int count);
    
    public String deleteCartLine(int cartLineId);
    
    public String addCartLine(int productId);
    
    public String validateCartLine();
        
}
