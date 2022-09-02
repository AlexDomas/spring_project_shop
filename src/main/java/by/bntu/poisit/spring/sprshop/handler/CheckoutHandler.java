package by.bntu.poisit.spring.sprshop.handler;

import by.bntu.poisit.spring.sprshop.dto.CheckoutDto;
import by.bntu.poisit.spring.sprshop.dto.UserProfileDataDto;
import by.bntu.poisit.spring.sprshop.entity.Address;
import by.bntu.poisit.spring.sprshop.entity.Cart;
import by.bntu.poisit.spring.sprshop.entity.CartLine;
import by.bntu.poisit.spring.sprshop.entity.OrderDetail;
import by.bntu.poisit.spring.sprshop.entity.OrderItem;
import by.bntu.poisit.spring.sprshop.entity.Product;
import by.bntu.poisit.spring.sprshop.entity.User;
import by.bntu.poisit.spring.sprshop.service.CartLineService;
import by.bntu.poisit.spring.sprshop.service.ProductService;
import by.bntu.poisit.spring.sprshop.service.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CheckoutHandler {

	private static final Logger logger = LoggerFactory.getLogger(CheckoutHandler.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;

	@Autowired
	private CartLineService cartLineService;
	
	@Autowired
	private HttpSession session;
	
	
	public CheckoutDto init(String name) throws Exception{

		User user = userService.getUserByEmail(name);
		CheckoutDto checkoutDto = null;	

		if(user!=null) {
			checkoutDto = new CheckoutDto();
			checkoutDto.setUser(user);
			checkoutDto.setCart(user.getCart());
			
			double checkoutTotal = 0.0;
			List<CartLine> cartLines = cartLineService.listAvailable(user.getCart().getId());

			if(cartLines.size() == 0 ) {
				throw new Exception("There are no products available for checkout now!");
			}
			
			for(CartLine cartLine: cartLines) {
				checkoutTotal += cartLine.getTotal();
			}
			
			checkoutDto.setCartLines(cartLines);
			checkoutDto.setCheckoutTotal(checkoutTotal);			
		}			
		
		return checkoutDto;
	}
	
	
	public List<Address> getShippingAddresses(CheckoutDto checkoutDto) {
				
		List<Address> addresses = userService.listShippingAddresses(checkoutDto.getUser().getId());
		
		if(addresses.isEmpty()) {
			addresses = new ArrayList<>();
		}

		addresses.add(addresses.size(), userService.getBillingAddress(checkoutDto.getUser().getId()));			
		
		return addresses;
		
	}
	
	public String saveAddressSelection(CheckoutDto checkoutDto, int shippingId) {

		String transitionValue = "success";
		
		Address shipping = userService.getAddress(shippingId);		
		
		checkoutDto.setShipping(shipping);
		
		return transitionValue;
		
	}
			
	
	public String saveAddress(CheckoutDto checkoutDto, Address shipping) {

		String transitionValue = "success";
		
		// set the user id
		// set shipping as true
		shipping.setUserId(checkoutDto.getUser().getId());
		shipping.setShipping(true);
		userService.addAddress(shipping);
		
		// set the shipping id to flowScope object
		checkoutDto.setShipping(shipping);
		
		return transitionValue;
		
	}
		

	public String saveOrder(CheckoutDto checkoutModel) {
		String transitionValue = "success";	
		
		// create a new order object
		OrderDetail orderDetail = new OrderDetail();
				
		// attach the user 
		orderDetail.setUser(checkoutModel.getUser());
				
		// attach the shipping address
		orderDetail.setShipping(checkoutModel.getShipping());
		
		// fetch the billing address
		Address billing = userService.getBillingAddress(checkoutModel.getUser().getId());		
		orderDetail.setBilling(billing);

		List<CartLine> cartLines = checkoutModel.getCartLines();
		OrderItem orderItem = null;
		
		double orderTotal = 0.0;
		int orderCount = 0;
                
		Product product = null;
		
		for(CartLine cartLine : cartLines) {
			
			orderItem = new OrderItem();
			
			orderItem.setBuyingPrice(cartLine.getBuyingPrice());
			orderItem.setProduct(cartLine.getProduct());
			orderItem.setProductCount(cartLine.getProductCount());
			orderItem.setTotal(cartLine.getTotal());
			
			orderItem.setOrderDetail(orderDetail);
			orderDetail.getOrderItems().add(orderItem);
			
			orderTotal += orderItem.getTotal();
			orderCount++;
			
			// update the product
			// reduce the quantity of product
			product = cartLine.getProduct();
			product.setQuantity(product.getQuantity() - cartLine.getProductCount());
			product.setPurchases(product.getPurchases() + cartLine.getProductCount());
			productService.update(product);
			
			// delete the cartLine
			cartLineService.delete(cartLine);
			
		}
		
		orderDetail.setOrderTotal(orderTotal);
		orderDetail.setOrderCount(orderCount);
		orderDetail.setOrderDate(new Date());
		
		// save the order
		cartLineService.addOrderDetail(orderDetail);

		// set it to the orderDetails of checkoutModel
		checkoutModel.setOrderDetail(orderDetail);

		
		// update the cart
		Cart cart = checkoutModel.getCart();
		cart.setGrandTotal(cart.getGrandTotal() - orderTotal);
		cart.setCartLines(cart.getCartLines() - orderCount);
		cartLineService.updateCart(cart);
		
		// update the cart if its in the session
		UserProfileDataDto userDto = (UserProfileDataDto) session.getAttribute("userProfileDataDto");
		if(userDto!=null) {
			userDto.setCart(cart);
		}
		
				
		return transitionValue;		
	}

	
	public OrderDetail getOrderDetail(CheckoutDto checkoutDto) {
		return checkoutDto.getOrderDetail();
	}
	
	
	
}
