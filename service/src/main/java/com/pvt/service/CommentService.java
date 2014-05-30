package com.pvt.service;

import com.pvt.dao.ICommentDao;
import com.pvt.daoEntities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 12.05.14
 * Time: 0:17
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CommentService implements ICommentService {

    @Autowired
    ICommentDao commentDao;
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer getCurrentNumberOfComment(Integer newsId){
         return commentDao.getNextNumberOfComment(newsId);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Comment comment){
        commentDao.save(comment);
    }
}
