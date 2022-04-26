package by.bntu.poisit.spring.sprshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    @NotBlank(message = "Please enter the product name!")
    @Size(min = 3, max = 50, message = "Product name must be between 4 and 50 characters!")
    private String name;
    @NotBlank(message = "Please enter the brand name!")
    @Size(min = 3, max = 50, message = "Brand name must be between 4 and 50 characters!")
    private String brand;
    @NotBlank(message = "Please enter the description!")
    @Size(min = 5, max = 255, message = "Product Description must be between 5 and 255 characters!")
    @JsonIgnore
    private String description;
    @Column(name = "unit_price")
    @Min(value = 1, message = "Please select at least one value!")
    private double unitPrice;
    private int quantity;
    @Column(name = "is_active")
    private boolean active;
    @Column(name = "category_id")
    @JsonIgnore
    private int categoryId;
    @Column(name = "supplier_id")
    @JsonIgnore
    private int supplierId;
    private int purchases;
    private int views;

    @Transient
    private MultipartFile file;

    public Product() {
        this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
                + description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active
                + ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views="
                + views + "]";
    }

}
