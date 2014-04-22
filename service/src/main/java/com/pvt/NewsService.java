package com.pvt;

import com.pvt.dao.NewsDao;

import java.io.Serializable;

public class NewsService {
    NewsDao newsdao = new NewsDao();
    public void saveNews(News news){
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

}