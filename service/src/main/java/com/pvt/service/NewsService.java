package com.pvt.service;

import com.pvt.daoEntities.News;
import com.pvt.dao.NewsDaoImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class NewsService implements INewsService {

    News news;

    @Autowired
    NewsDaoImplementation newsDao;

    public void save(News news){
        newsDao.save(news);
    }
    public void deleteNews(News news){
        newsDao.delete(news);
    }

    public void deleteNews(Integer id){
        news = new News();
        news.setId(id);
        newsDao.delete(news);
    }
    public void updateNews(News news){
        newsDao.update(news);
    }
    public News getNewsById(Serializable id){
        return newsDao.getById(id);
    }

    public List<News> getNewsList(){
        try {
            return newsDao.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<News> getNewsByCategoryId(Integer id){
        return newsDao.getNewsByCategoryId(id);
    }
}
