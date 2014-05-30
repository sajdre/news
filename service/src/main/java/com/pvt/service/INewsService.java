package com.pvt.service;

import com.pvt.daoEntities.News;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 27.05.14
 * Time: 11:45
 * To change this template use File | Settings | File Templates.
 */
public interface INewsService {

    public void save(News news);
    public void deleteNews(News news);
    public void deleteNews(Integer id);
    public void updateNews(News news);
    public News getNewsById(Serializable id);

    public List<News> getNewsList();

    public List<News> getNewsByCategoryId(Integer id);

}
