package com.pvt.dao;

import com.pvt.News;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 18.04.14
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
public class NewsDao extends CommonDao<News> {
    public NewsDao() {
        super(News.class);
    }
}
