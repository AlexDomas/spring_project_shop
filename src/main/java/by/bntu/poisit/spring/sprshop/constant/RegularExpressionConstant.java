package by.bntu.poisit.spring.sprshop.constant;

public class RegularExpressionConstant {
    
    public static final String PASSWORD_REGULAR_EXPRESSION = "(?=(.*[0-9]))((?=.*[A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z]))^.{8,40}$";
    public static final String PHONE_NUMBER_REGULAR_EXPRESSION = "^\\+[1-9]{1}[0-9]{3,14}$";
    
}
