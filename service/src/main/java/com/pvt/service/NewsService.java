package com.pvt.service;

import com.pvt.dao.INewsDao;
import com.pvt.daoEntities.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NewsService implements INewsService {

    News news;

    @Autowired
    INewsDao newsDao;
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(News news){
        newsDao.save(news);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteNews(News news){
        newsDao.delete(news);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteNews(Integer id){
        news = new News();
        news.setId(id);
        newsDao.delete(news);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateNews(News news){
        newsDao.update(news);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public News getNewsById(Serializable id){
        return newsDao.getById(id);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public List<News> getNewsList(){
        try {
            return newsDao.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public List<News> getNewsByCategoryId(Integer id){
        return newsDao.getNewsByCategoryId(id);
    }
}
