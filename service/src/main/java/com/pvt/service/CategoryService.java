package com.pvt.service;

import com.pvt.daoEntities.Category;
import com.pvt.daoEntities.News;
import com.pvt.dao.CategoryDaoImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class CategoryService implements ICategoryService {

    Category cat;

    @Autowired
    CategoryDaoImplementation categoryDao;

    public void saveCategory(Category category){
        categoryDao.save(category);
    }
    public void saveCategory(String category){
        cat = new Category();
        cat.setCategory(category);
        categoryDao.save(cat);
    };

    public void deleteCategory(Category category){
        categoryDao.delete(category);
    }
    public void deleteCategory(Integer id){
        Category cat = new Category();
        cat.setId(id);
        categoryDao.delete(cat);
    }
    public void updateCategory(Category category){
        categoryDao.update(category);
    }

    public Category getCategoryById(Serializable id){
        return categoryDao.getById(id);
    }

    public List<Category> getCategoryList(){
        List<Category> list = null;
        try {
          list = categoryDao.list();
        } catch (Exception e) {
    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
}
        return list;
    }

    public List<News> getNewsByCategory(Category cat){
        return categoryDao.getNewsByCategory(cat);
    }

}
