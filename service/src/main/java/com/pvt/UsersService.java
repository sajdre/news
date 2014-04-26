package com.pvt;

import com.pvt.dao.UsersDao;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 18.04.14
 * Time: 20:11
 * To change this template use File | Settings | File Templates.
 */
public class UsersService {
    UsersDao usersdao = new UsersDao();

    public Users getUserById(Serializable id){
        Users user;
        user = usersdao.getById(id);
        return user;
    }
}
