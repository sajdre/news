package com.pvt.dao;

import com.pvt.daoEntities.News;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 27.05.14
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
public interface INewsDao extends ICommonDao<News> {

    public List<News> getNewsByCategoryId(Integer id);

}
