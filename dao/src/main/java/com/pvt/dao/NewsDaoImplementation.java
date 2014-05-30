package com.pvt.dao;

import com.pvt.daoEntities.News;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 18.04.14
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class NewsDaoImplementation extends CommonDaoImplementation<News> implements INewsDao{

    Session session;

    Logger log = Logger.getLogger(NewsDaoImplementation.class);

    @Autowired
    public SessionFactory sessionFactory;

    public NewsDaoImplementation() {
        super(News.class);
    }

    public List<News> getNewsByCategoryId(Integer id){
        session = sessionFactory.getCurrentSession();
        t = session.beginTransaction();
        Criteria cr = session.createCriteria(News.class);
        Criterion rest = Restrictions.eq("category_id", id);
        List<News> newslist = null;

        try{
        newslist = cr.add(rest).list();
        t.commit();
        }catch(RuntimeException e){
            log.info("Couldn`t get news", e);
            try{
                t.rollback();
            }catch (RuntimeException rbe){
                log.info("Couldn`t rollback transaction", rbe);
            }
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return newslist;
    }
}
