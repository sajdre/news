package com.pvt.dao;

import com.pvt.utils.Hbutils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class CommonDao<T> implements DaoI<T> {

    Logger log = Logger.getLogger(CommonDao.class);
    Session session = Hbutils.getSessionFactory().getCurrentSession();
    protected Class<T> clazz;

    public CommonDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void save(T entity) {
        if (entity == null) {
            throw new NullPointerException();
        }
        try{
        Transaction t = session.beginTransaction();
        session.save(entity);
        t.commit();
        }catch(Exception e){
              e.printStackTrace();
        }
    }

    public void delete(T entity) {
        if (entity == null) {
            throw new NullPointerException();
        }
        Transaction trans = session.getTransaction();
        if(!(trans.isActive())){
            trans.begin();
        }
        session.delete(entity);
        trans.commit();
    }

    public void update(T entity) {
        if (entity == null) {
            throw new NullPointerException();
        }
        try {
            Transaction trans = session.beginTransaction();
            session.update(entity);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public T getById(Serializable id) {
        T t = null;
        try{
        Transaction tran = session.getTransaction();
        if(!(tran.isActive())){
           tran.begin();
            }
        t = (T) session.get(clazz, id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return t;
    }

    public List<T> list() throws Exception {
        try {
            Transaction t = session.beginTransaction();
            List<T> list = session.createCriteria(clazz).list();
            t.commit();
            return list;
        } catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }
}

