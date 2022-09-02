package by.bntu.poisit.spring.sprshop.dto;

import by.bntu.poisit.spring.sprshop.entity.Address;
import by.bntu.poisit.spring.sprshop.entity.Cart;
import by.bntu.poisit.spring.sprshop.entity.CartLine;
import by.bntu.poisit.spring.sprshop.entity.OrderDetail;
import by.bntu.poisit.spring.sprshop.entity.User;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckoutDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;
	private Address shipping;
	private Cart cart;
	private List<CartLine> cartLines;
	private OrderDetail orderDetail;
	private double checkoutTotal;
	
}
