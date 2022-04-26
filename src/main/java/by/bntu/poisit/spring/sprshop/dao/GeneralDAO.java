
package by.bntu.poisit.spring.sprshop.dao;

import java.util.List;


public interface GeneralDAO<T>{
    
    List<T> list();
    
    T get(int id);    
    
    public boolean add(T object);
    
    public boolean update(T object);
    
    public boolean delete(T object);
    
}
