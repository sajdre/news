package com.pvt.service;

import com.pvt.daoEntities.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 27.05.14
 * Time: 11:47
 * To change this template use File | Settings | File Templates.
 */
public interface IUserService {

    public User getUserById(Serializable id);

    public void update(User user);

    public List<User> getUserBy(String email, String firstname, String secondname);

    public void save(User user);

    public Boolean isAdmin(User user);

    public Boolean isUser(User user);

    public Boolean isAuthor(User user);

}
