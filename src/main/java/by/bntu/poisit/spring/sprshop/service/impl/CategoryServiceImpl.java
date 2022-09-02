
package by.bntu.poisit.spring.sprshop.service.impl;

import by.bntu.poisit.spring.sprshop.dao.CategoryDAO;
import by.bntu.poisit.spring.sprshop.entity.Category;
import by.bntu.poisit.spring.sprshop.service.CategoryService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    private CategoryDAO categoryDAO;
    
    @Override
    @Transactional
    public Category get(int id){
        
        return categoryDAO.get(id);
        
    }

    @Override
    @Transactional
    public boolean add(Category category) {
        
        return categoryDAO.add(category);
        
    }

    @Override
    @Transactional
    public List<Category> list() {
        return categoryDAO.list();
    }

    @Override
    @Transactional
    public boolean update(Category category) {
        return categoryDAO.update(category);
    }

    @Override
    @Transactional
    public boolean delete(Category category) {
        return categoryDAO.delete(category);
    }
    
}
