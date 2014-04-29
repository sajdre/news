package com.pvt.daoImplementation;

import com.pvt.Category;
import com.pvt.News;
import com.pvt.daoInterface.CommonDao;
import com.pvt.hibernateUtil.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 18.04.14
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
public class CategoriesDao extends CommonDao<Category> {

    public CategoriesDao() {
        super(Category.class);
    }
    public List<News> getNewsByCategory(Category cat){
        List<News> news = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
        session.beginTransaction();
        Query query = session.createQuery("FROM News WHERE category =" + cat.getId());
        news = (List<News>) query.list();
        session.getTransaction().commit();
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
        return news;
    }
}
