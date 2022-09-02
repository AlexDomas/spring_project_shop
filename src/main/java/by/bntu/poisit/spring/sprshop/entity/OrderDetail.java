package by.bntu.poisit.spring.sprshop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {
    
	private static final long serialVersionUID = 1L;
        
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
        
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
        
	@Column(name = "order_total")
	private double orderTotal;
        
	@ManyToOne
	private Address shipping;
        
	@ManyToOne
	private Address billing;
        
	@OneToMany(mappedBy="orderDetail", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<>();
	
	@Column(name = "order_count")
	private int orderCount;
	
	@Column(name="order_date")
	private Date orderDate;
	
}
