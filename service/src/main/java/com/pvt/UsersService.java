package com.pvt;

import com.pvt.dao.UsersDao;

import java.io.Serializable;


public class UsersService {
    UsersDao usersdao = new UsersDao();


    public Users getUserById(Serializable id){
        Users user;
        user = usersdao.getById(id);
        return user;

    }


}