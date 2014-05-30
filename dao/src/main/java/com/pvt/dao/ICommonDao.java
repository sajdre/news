package com.pvt.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 27.05.14
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 */
public interface ICommonDao<T> {
    public void save(T entity);
    public void delete(T entity);
    public void update(T entity);
    public T getById(Serializable id);
    public List<T> list();
}
