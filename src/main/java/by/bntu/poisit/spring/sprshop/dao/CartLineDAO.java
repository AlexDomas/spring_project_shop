package by.bntu.poisit.spring.sprshop.dao;

import by.bntu.poisit.spring.sprshop.entity.Cart;
import by.bntu.poisit.spring.sprshop.entity.CartLine;
import by.bntu.poisit.spring.sprshop.entity.OrderDetail;
import java.util.List;

public interface CartLineDAO extends GeneralDAO<CartLine>{
    
    public List<CartLine> list(int cartId);
    
    public List<CartLine> listAvailable(int cartId);
    
    public CartLine getByCartAndProduct(int cartId, int productId);
    
    public boolean updateCart(Cart cart);
    
    public boolean addOrderDetail(OrderDetail orderDetail);
    
}
