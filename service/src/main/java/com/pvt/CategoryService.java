package com.pvt;

import com.pvt.dao.CategoriesDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 18.04.14
 * Time: 20:47
 * To change this template use File | Settings | File Templates.
 */
public class CategoryService {
    CategoriesDao categorydao = new CategoriesDao();
    public void saveCategory(Category category){
        categorydao.save(category);
    }
    public void deleteCategory(Category category){
        categorydao.delete(category);
    }
    public void updateCategory(Category category){
        categorydao.update(category);
    }
    public Category getCategoryById(Serializable id){
        return categorydao.getById(id);
    }

    public List<Category> getCategoryList(){
        List<Category> list = null;
        try {
          list = categorydao.list();
        } catch (Exception e) {
    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
}
        return list;
    }


}
