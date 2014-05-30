package com.pvt.service;

import com.pvt.daoEntities.Comment;
import com.pvt.dao.CommentDaoImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 12.05.14
 * Time: 0:17
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CommentService implements ICommentService {

    @Autowired
    CommentDaoImplementation commentDao;

    public Integer getCurrentNumberOfComment(Integer newsId){
         return commentDao.getNextNumberOfComment(newsId);
    }
    public void save(Comment comment){
        commentDao.save(comment);
    }
}
