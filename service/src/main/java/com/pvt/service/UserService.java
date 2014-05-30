package com.pvt.service;

import com.pvt.dao.IUserDao;
import com.pvt.daoEntities.Role;
import com.pvt.daoEntities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 18.04.14
 * Time: 20:11
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    IUserDao usersDao;
    @Transactional(propagation = Propagation.REQUIRED)
    public User getUserById(Serializable id){
        User user;
        user = usersDao.getById(id);
        return user;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(User user){
        usersDao.update(user);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> getUserBy(String email, String firstname, String secondname){
        return usersDao.getUserByCriteria(email, firstname, secondname);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(User user){
        usersDao.save(user);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean isAdmin(User user){
        List<Role> roles = user.getRoles();
        Iterator iterator = roles.iterator();
        while(iterator.hasNext()){
            Integer id = ((Role) iterator.next()).getId();
            if(id == 1){
                return true;
            }
        }
        return false;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean isUser(User user){
        List<Role> roles = user.getRoles();
        Iterator iterator = roles.iterator();
        while(iterator.hasNext()){
            Integer id = ((Role) iterator.next()).getId();
            if(id == 2){
                return true;
            }
        }
        return false;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public Boolean isAuthor(User user){
        List<Role> roles = user.getRoles();
        Iterator iterator = roles.iterator();
        while(iterator.hasNext()){
            Integer id = ((Role) iterator.next()).getId();
            if(id == 3){
                return true;
            }
        }
        return false;
    }
}
