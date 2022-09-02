package by.bntu.poisit.spring.sprshop.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cart_line")
public class CartLine implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Product product;
	@Column(name = "cart_id")
	private int cartId;	
	@Column(name = "product_count")
	private int productCount;
	private double total;
	@Column(name = "buying_price")
	private double buyingPrice;
	@Column(name = "is_available")
	private boolean available = true;
	
}
