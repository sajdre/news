package com.pvt;

import com.pvt.daoEntities.Comment;
import com.pvt.daoImplementation.CommentDao;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 12.05.14
 * Time: 0:17
 * To change this template use File | Settings | File Templates.
 */
public class CommentService {
    CommentDao cd = new CommentDao();

    public Integer getCurrentNumberOfComment(Integer newsId){
         return cd.getNextNumberOfComment(newsId);
    }
    public void save(Comment comment){
         cd.save(comment);
    }
}
