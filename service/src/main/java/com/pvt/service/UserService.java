package com.pvt.service;

import com.pvt.daoEntities.Role;
import com.pvt.daoEntities.User;
import com.pvt.dao.UserDaoImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    UserDaoImplementation usersDao;

    public User getUserById(Serializable id){
        User user;
        user = usersDao.getById(id);
        return user;
    }

    public void update(User user){
        usersDao.update(user);
    }

    public List<User> getUserBy(String email, String firstname, String secondname){
        return usersDao.getUserByCriteria(email, firstname, secondname);
    }

    public void save(User user){
        usersDao.save(user);
    }

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
