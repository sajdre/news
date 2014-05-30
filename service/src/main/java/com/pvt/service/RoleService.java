package com.pvt.service;

import com.pvt.dao.RoleDaoImplementation;
import com.pvt.daoEntities.Role;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    Logger logger = Logger.getLogger(RoleService.class);

    @Autowired
    RoleDaoImplementation roleDao;

    Session session;

    @Autowired
    SessionFactory sessionFactory;

    public List<Role> getRoleList(){
        List <Role> roleList = null;

        try {
            roleList = roleDao.list();
        } catch (Exception e) {
            logger.info(e);
        }
        return roleList;
    }

    public List<Role> getRoleListById(Integer [] ids){

        return roleDao.getRoleListById(ids);

    }

    public Role getRoleById(Integer id){

        return roleDao.getRoleById(id);

    }


}
