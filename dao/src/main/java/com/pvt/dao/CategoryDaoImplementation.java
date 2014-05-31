package com.pvt.dao;

import com.pvt.daoEntities.Category;
import com.pvt.daoEntities.News;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 18.04.14
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CategoryDaoImplementation extends CommonDaoImplementation<Category> implements ICategoryDao{

    public CategoryDaoImplementation(){
        super(Category.class);
    }

    @Autowired
    public SessionFactory sessionFactory;

    public List<News> getNewsByCategory(Category cat){
        Logger log = Logger.getLogger(CategoryDaoImplementation.class);
        List<News> news = null;

        Query query = sessionFactory.getCurrentSession().createQuery("FROM News WHERE category =" + cat.getId());
        news = (List<News>) query.list();
        return news;
    }

    public void saveCategory(String category){
        Category cat = new Category();
        cat.setCategory(category);
        save(cat);
    }
}
