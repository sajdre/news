package com.pvt.daoImplementation;

import com.pvt.Users;
import com.pvt.daoInterface.CommonDao;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 18.04.14
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
public class UsersDao extends CommonDao<Users> {

    public UsersDao() {
        super(Users.class);
    }
}
