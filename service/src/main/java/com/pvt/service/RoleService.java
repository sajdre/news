package com.pvt.service;

import com.pvt.dao.IRoleDao;
import com.pvt.daoEntities.Role;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    Logger logger = Logger.getLogger(RoleService.class);

    @Autowired
    IRoleDao roleDao;

    Session session;

    @Autowired
    SessionFactory sessionFactory;
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Role> getRoleList(){
        List <Role> roleList = null;

        try {
            roleList = roleDao.list();
        } catch (Exception e) {
            logger.info(e);
        }
        return roleList;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Role> getRoleListById(Integer [] ids){

        return roleDao.getRoleListById(ids);

    }
    @Transactional(propagation = Propagation.REQUIRED)
    public Role getRoleById(Integer id){

        return roleDao.getRoleById(id);

    }


}
