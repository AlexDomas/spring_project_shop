package by.bntu.poisit.spring.sprshop.service.impl;

import by.bntu.poisit.spring.sprshop.dao.CartLineDAO;
import by.bntu.poisit.spring.sprshop.dto.CartLine;
import by.bntu.poisit.spring.sprshop.service.CartLineService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartLineServiceImpl implements CartLineService{

    @Autowired
    private CartLineDAO cartLineDAO;
    
    @Override
    @Transactional
    public List<CartLine> list(int cartId) {
        return cartLineDAO.list(cartId);
    }

    @Override
    @Transactional
    public List<CartLine> listAvailable(int cartId) {
        return cartLineDAO.listAvailable(cartId);
    }

    @Override
    @Transactional
    public CartLine getByCartAndProduct(int cartId, int productId) {
        return cartLineDAO.getByCartAndProduct(cartId, productId);
    }

    @Override
    @Transactional
    public List<CartLine> list() {
        return cartLineDAO.list();
    }

    @Override
    @Transactional
    public CartLine get(int id) {
        return cartLineDAO.get(id);
    }

    @Override
    @Transactional
    public boolean add(CartLine cartLine) {
        return cartLineDAO.add(cartLine);
    }

    @Override
    @Transactional
    public boolean update(CartLine cartLine) {
        return cartLineDAO.update(cartLine);
    }

    @Override
    @Transactional
    public boolean delete(CartLine cartLine) {
        return cartLineDAO.delete(cartLine);
    }
    
}
