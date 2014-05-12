package com.pvt.daoImplementation;

import com.pvt.daoAbstract.CommonDao;
import com.pvt.daoConfiguration.HibernateUtil;
import com.pvt.daoEntities.News;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 18.04.14
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
public class NewsDao extends CommonDao<News> {
    Logger log = Logger.getLogger(NewsDao.class);
    public NewsDao() {
        super(News.class);
    }

    public List<News> getNewsByCategoryId(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
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
