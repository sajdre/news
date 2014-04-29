package com.pvt.daoAbstract;

import com.pvt.daoConfiguration.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public abstract class CommonDao<T> {

    public CommonDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    Logger log = Logger.getLogger(CommonDao.class);
    Session session;
    Transaction t;
    protected Class<T> clazz;



    public void save(T entity) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        if (entity == null) {
            throw new NullPointerException();
        }
        try{
        t = session.beginTransaction();
        session.save(entity);
        t.commit();
        }catch(RuntimeException e){
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
    }

    public void delete(T entity) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        if (entity == null) {
            throw new NullPointerException();
        }
        try{
        t = session.beginTransaction();
        session.delete(entity);
        t.commit();
        }catch(RuntimeException e){
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
    }

    public void update(T entity) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        if (entity == null) {
            throw new NullPointerException();
        }
        try {
            t = session.beginTransaction();
            session.update(entity);
            t.commit();
        }catch(RuntimeException e){
            try{
                log.info("SQLGrammarException", e);
                t.rollback();
            }catch (RuntimeException rbe){
                log.info("Couldn`t rollback transaction", rbe);
            }
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public T getById(Serializable id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        T entity = null;
        try{
        t = session.beginTransaction();
        entity = (T) session.get(clazz, id);
        }catch(RuntimeException e){
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
        return entity;
    }

    public List<T> list() throws Exception {
        List<T> list = null;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            t = session.beginTransaction();
            list = session.createCriteria(clazz).list();
            t.commit();

        } catch(RuntimeException e){
            try{
                log.info("SQLGrammarException", e);
                t.rollback();
            }catch (RuntimeException rbe){
                log.info("Couldn`t rollback transaction", rbe);
            }
        }finally {
            if (session != null && session.isOpen()) {
            session.close();
        }
        }
        return list;
    }
}

