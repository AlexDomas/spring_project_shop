
package by.bntu.poisit.spring.sprshop.service;

import java.util.List;


public interface GeneralService<T> {
    
    List<T> list();
    
    T get(int id);  
    
    public boolean add(T object);
    
    public boolean update(T object);
    
    public boolean delete(T object);
    
}
