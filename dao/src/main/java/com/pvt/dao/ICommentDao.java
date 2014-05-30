package com.pvt.dao;

import com.pvt.daoEntities.Comment;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 27.05.14
 * Time: 11:05
 * To change this template use File | Settings | File Templates.
 */
public interface ICommentDao extends ICommonDao<Comment> {
    public Integer getNextNumberOfComment(Integer newsId);
}
