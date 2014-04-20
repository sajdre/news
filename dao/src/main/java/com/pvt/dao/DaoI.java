package com.pvt.dao;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 18.04.14
 * Time: 18:48
 * To change this template use File | Settings | File Templates.
 */
public interface DaoI<T> {
    public void save(T entity);
    public void delete(T entity);
    public void update(T entity);
    public T getById(Serializable id);

}
