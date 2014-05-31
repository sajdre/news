package com.pvt.service;

import com.pvt.dao.ICategoryDao;
import com.pvt.daoEntities.Category;
import com.pvt.daoEntities.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 18.04.14
 * Time: 20:47
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CategoryService implements ICategoryService {

    Category cat;

    @Autowired
    ICategoryDao categoryDao;
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveCategory(Category category){
        categoryDao.save(category);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveCategory(String category){
        cat = new Category();
        cat.setCategory(category);
        categoryDao.save(cat);
    };
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteCategory(Category category){
        categoryDao.delete(category);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteCategory(Integer id){
        Category cat = new Category();
        cat.setId(id);
        categoryDao.delete(cat);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateCategory(Category category){
        categoryDao.update(category);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public Category getCategoryById(Serializable id){
        return categoryDao.getById(id);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Category> getCategoryList(){
        List<Category> list = null;
        try {
          list = categoryDao.list();
        } catch (Exception e) {
    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
}
        return list;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public List<News> getNewsByCategory(Category cat){
        return categoryDao.getNewsByCategory(cat);
    }

}
