package com.pvt.daoImplementation;

import com.pvt.daoAbstract.CommonDao;
import com.pvt.daoConfiguration.HibernateUtil;
import com.pvt.daoEntities.Comment;
import com.pvt.daoEntities.News;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 12.05.14
 * Time: 0:18
 * To change this template use File | Settings | File Templates.
 */
public class CommentDao extends CommonDao<Comment> {
    Logger log = Logger.getLogger(clazz);
    NewsDao ns = new NewsDao();
    public CommentDao() {
        super(Comment.class);
    }

    public Integer getNextNumberOfComment(Integer newsId){
        News news = ns.getById(newsId);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        t = session.beginTransaction();
        Integer maxNumber = null;
        try{
        DetachedCriteria maxNumberDC = DetachedCriteria.forClass(Comment.class).setProjection(Projections.max("number"));
        Criterion criterion = Restrictions.eq("news", news);
        List<Comment> maxNumberList = session.createCriteria(clazz).add(criterion).add(Property.forName("number").eq(maxNumberDC)).list();
        if(maxNumberList.size() == 0){
            return 1;
        }
        maxNumber = ((Comment)maxNumberList.get(0)).getNumber();
        t.commit();
        }catch(RuntimeException e){
            log.info("Couldn`t get number of comment", e);
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
        return ++maxNumber;
    }
}
