
package br.bntu.poisit.spring.sprshop.constants;


public class SQLContants {
    
    public static final String SELECT_ACTIVE_CATEGORY = "FROM Category WHERE active = :active";
    
    public static final String SELECT_ALL_PRODUCTS = "FROM Product";
    public static final String SELECT_ACTIVE_PRODUCTS = "FROM Product WHERE active = :active";
    public static final String SELECT_ACTIVE_PRODUCTS_BY_CATEGORY = "FROM Product WHERE active = :active AND categoryId = :categoryId";
    public static final String GET_LATEST_ACTIVE_PRODUCTS = "FROM Product WHERE active = :active ORDER BY id";
}
