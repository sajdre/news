package com.pvt;

import com.pvt.daoEntities.Role;
import com.pvt.daoEntities.User;
import com.pvt.daoImplementation.UserDao;

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
public class UserService {
    UserDao usersdao = new UserDao();

    public User getUserById(Serializable id){
        User user;
        user = usersdao.getById(id);
        return user;
    }

    public void update(User user){
        usersdao.update(user);
    }

    public List<User> getUserBy(String email, String firstname, String secondname){
        return usersdao.getUserByCriteria(email, firstname, secondname);
    }

    public void save(User user){
        usersdao.save(user);
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
