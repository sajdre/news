package com.pvt;

import com.pvt.dao.NewsDao;

import java.io.Serializable;
import java.util.List;


public class NewsService {
    NewsDao newsdao;


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
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}
