package com.pvt.service;

import com.pvt.daoEntities.Category;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 27.05.14
 * Time: 11:41
 * To change this template use File | Settings | File Templates.
 */
public interface ICategoryService {

    public void saveCategory(Category category);
    public void saveCategory(String category);
    public void deleteCategory(Category category);
    public void deleteCategory(Integer id);
    public void updateCategory(Category category);
    public Category getCategoryById(Serializable id);

    public List<Category> getCategoryList();

}
