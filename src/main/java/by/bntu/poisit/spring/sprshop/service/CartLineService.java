package by.bntu.poisit.spring.sprshop.service;

import by.bntu.poisit.spring.sprshop.dto.CartLine;
import java.util.List;

public interface CartLineService extends GeneralService<CartLine>{
    
    public List<CartLine> list(int cartId);
    
    public List<CartLine> listAvailable(int cartId);
    
    public CartLine getByCartAndProduct(int cartId, int productId);
    
}
