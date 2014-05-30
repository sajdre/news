package com.pvt.dao;

import com.pvt.daoEntities.Comment;
import com.pvt.daoEntities.News;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 12.05.14
 * Time: 0:18
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CommentDaoImplementation extends CommonDaoImplementation<Comment> implements ICommentDao {

    Session session;

    Logger log = Logger.getLogger(clazz);

    NewsDaoImplementation ns = new NewsDaoImplementation();

    @Autowired
    public SessionFactory sessionFactory;

    public CommentDaoImplementation() {
        super(Comment.class);
    }

    public Integer getNextNumberOfComment(Integer newsId){
        News news = ns.getById(newsId);
        session = sessionFactory.getCurrentSession();
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
