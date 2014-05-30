package com.pvt.service;

import com.pvt.daoEntities.Comment;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 27.05.14
 * Time: 11:44
 * To change this template use File | Settings | File Templates.
 */
public interface ICommentService {

    public Integer getCurrentNumberOfComment(Integer newsId);

    public void save(Comment comment);

}
