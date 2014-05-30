package com.pvt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;
public abstract class CommonDaoImplementation<T> implements ICommonDao<T> {

    Logger logger = LoggerFactory.getLogger(CommonDaoImplementation.class);

    public SessionFactory sessionFactory;

    public CommonDaoImplementation(Class<T> clazz) {
        this.clazz = clazz;
    }

    Session session;
    protected Transaction t = null;
    protected Class<T> clazz;
    protected List<T> list = null;



    public void save(T entity) {
        session = sessionFactory.getCurrentSession();
        if (entity == null) {
            throw new NullPointerException();
        }
        try{
        t = session.beginTransaction();
        session.save(entity);
        t.commit();
        }catch(RuntimeException e){
            try{
                logger.info("HibernateException", e);
                t.rollback();
            }catch (RuntimeException rbe){
                logger.info("Couldn`t rollback transaction", rbe);
            }
        }finally {
            if (session != null && session.isOpen()) {
            session.close();
        }
        }
    }

    public void delete(T entity) {
        session = sessionFactory.getCurrentSession();
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
                logger.info("Couldn`t rollback transaction", rbe);
            }
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(T entity) {
        session = sessionFactory.getCurrentSession();
        if (entity == null) {
            throw new NullPointerException();
        }
        try {
            t = session.beginTransaction();
            session.update(entity);
            t.commit();
        }catch(RuntimeException e){
            try{
                logger.info("SQLGrammarException", e);
                t.rollback();
            }catch (RuntimeException rbe){
                logger.info("Couldn`t rollback transaction", rbe);
            }
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public T getById(Serializable id) {
        session = sessionFactory.getCurrentSession();
        T entity = null;
        try{
        t = session.beginTransaction();
        entity = (T) session.get(clazz, id);
        }catch(RuntimeException e){
            try{
                t.rollback();
            }catch (RuntimeException rbe){
                logger.info("Couldn`t rollback transaction", rbe);
            }
        }finally {
            if (session != null && session.isOpen()) {
            session.close();
            }
        }
        return entity;
    }

    public List<T> list() {
        session = sessionFactory.getCurrentSession();
        try {
            t = session.beginTransaction();
            list = session.createCriteria(clazz).list();
            t.commit();

        } catch(RuntimeException e){
            try{
                logger.info("SQLGrammarException", e);
                t.rollback();
            }catch (RuntimeException rbe){
                logger.info("Couldn`t rollback transaction", rbe);
            }
        }finally {
            if (session != null && session.isOpen()) {
            session.close();
        }
        }
        return list;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

