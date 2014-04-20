package com.pvt.dao;

import com.pvt.Category;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 18.04.14
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
public class CategoriesDao extends CommonDao<Category> {

    public CategoriesDao() {
        super(Category.class);
    }
}
