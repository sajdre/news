package com.pvt.dao;
import com.pvt.daoEntities.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 27.05.14
 * Time: 11:10
 * To change this template use File | Settings | File Templates.
 */
public interface IUserDao extends ICommonDao<User> {

    public List<User> getUserByCriteria(String email, String firstname, String secondname);

}
