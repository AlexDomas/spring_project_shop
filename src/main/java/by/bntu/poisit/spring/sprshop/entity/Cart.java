
package by.bntu.poisit.spring.sprshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    private User user;
    
    @Column(name = "grand_total")
    private double grandTotal;
    @Column(name = "cart_lines")
    private int cartLines;

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", grandTotal=" + grandTotal + ", cartLines=" + cartLines + '}';
    }
    
}
