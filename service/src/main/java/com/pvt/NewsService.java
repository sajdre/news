package com.pvt;

import com.pvt.daoEntities.News;
import com.pvt.daoImplementation.NewsDao;

import java.io.Serializable;
import java.util.List;


public class NewsService {
    NewsDao newsdao = new NewsDao();

    public void save(News news){
        newsdao.save(news);
    }
    public void deleteNews(News news){
        newsdao.delete(news);
    }
    public void updateNews(News news){
        newsdao.update(news);
    }
    public News getNewsById(Serializable id){
        return newsdao.getById(id);
    }

    public List<News> getNewsList(){
        try {
            return newsdao.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<News> getNewsByCategoryId(Integer id){
        return newsdao.getNewsByCategoryId(id);
    }
}
