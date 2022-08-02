
package by.bntu.poisit.spring.sprshop.constants;


public class SQLContants {
    
    public static final String SELECT_ACTIVE_CATEGORY = "FROM Category WHERE active = :active";
    
    public static final String SELECT_ALL_PRODUCTS = "FROM Product";
    public static final String SELECT_ACTIVE_PRODUCTS = "FROM Product WHERE active = :active";
    public static final String SELECT_ACTIVE_PRODUCTS_BY_CATEGORY = "FROM Product WHERE active = :active AND categoryId = :categoryId";
    public static final String GET_LATEST_ACTIVE_PRODUCTS = "FROM Product WHERE active = :active ORDER BY id";
    
    public static final String SELECT_ALL_CARTLINES = "FROM CartLine";
    public static final String GET_CARTLINE_BY_CART_ID = "FROM CartLine WHERE cartId = :cartId";
    public static final String GET_CARTLINE_BY_CART_AND_PRODUCT =  "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";
    public static final String GET_CARTLINE_BY_CART_ID_AND_AVAILABILITY = "FROM CartLine WHERE cartId = :cartId AND available = :available";
    
}
