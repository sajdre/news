package com.pvt;

import com.pvt.daoConfiguration.HibernateUtil;
import com.pvt.daoEntities.Role;
import com.pvt.daoImplementation.RoleDao;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class RoleService {
    Logger logger = Logger.getLogger(RoleService.class);
    RoleDao rd = new RoleDao();

    public List<Role> getRoleList(){
        List <Role> roleList = null;
        try {
            roleList = rd.list();
        } catch (Exception e) {
            logger.info(e);
        }
        return roleList;
    }

    public List<Role> getRoleListById(Integer [] ids){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Role.class);
        Criterion criterion = Restrictions.in("id", ids);
        List<Role> list = cr.add(criterion).list();
        t.commit();
        return list;

    }

    public Role getRoleById(Integer id){
        Role role;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Role.class);
        Criterion criterion = Restrictions.eq("id", id);
        List result = cr.add(criterion).list();
        role = (Role) result.get(0);
        t.commit();
        return role;

    }


}
