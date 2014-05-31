package com.pvt.dao;

import org.hibernate.SessionFactory;
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

    protected Class<T> clazz;
    protected List<T> list = null;



    public void save(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public void update(T entity) {

        sessionFactory.getCurrentSession().update(entity);
    }


    public T getById(Serializable id) {
        T entity = null;
        entity = (T) sessionFactory.getCurrentSession().get(clazz, id);
        return entity;
    }

    public List<T> list() {
        list = sessionFactory.getCurrentSession().createCriteria(clazz).list();
        return list;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

