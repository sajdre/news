package com.pvt.dao;

import com.pvt.daoEntities.Category;
import com.pvt.daoEntities.News;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 27.05.14
 * Time: 10:31
 * To change this template use File | Settings | File Templates.
 */
public interface ICategoryDao extends ICommonDao<Category> {
    public List<News> getNewsByCategory(Category category);
}
