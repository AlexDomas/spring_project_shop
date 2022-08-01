/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bntu.poisit.spring.sprshop.dao.impl;

import static br.bntu.poisit.spring.sprshop.constants.SQLContants.*;
import by.bntu.poisit.spring.sprshop.dao.CategoryDAO;
import by.bntu.poisit.spring.sprshop.dto.Category;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> list() {

        return sessionFactory
                .getCurrentSession()
                .createQuery(SELECT_ACTIVE_CATEGORY)
                .setParameter("active",true)
                .getResultList();
    }

    @Override
    public Category get(int id) {

        return sessionFactory
                .getCurrentSession()
                .get(Category.class, Integer.valueOf(id));

    }

    @Override

    public boolean add(Category category) {

        try {
            // add the category to the database table
            sessionFactory
                    .getCurrentSession()
                    .persist(category);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    /*
	 * Updating a single category
     */
    @Override
    public boolean update(Category category) {

        try {
            // add the category to the database table
            sessionFactory
                    .getCurrentSession()
                    .update(category);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Category category) {

        category.setActive(false);

        try {
            // add the category to the database table
            sessionFactory
                    .getCurrentSession()
                    .update(category);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
