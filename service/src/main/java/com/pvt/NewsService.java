package com.pvt;

import com.pvt.dao.NewsDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 18.04.14
 * Time: 20:51
 * To change this template use File | Settings | File Templates.
 */
public class NewsService {
    NewsDao newsdao = new NewsDao();
    int i = 1;
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
    public List<News> getNewsList(){
        try {
            return newsdao.list();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}
