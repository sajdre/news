package com.pvt.dao;

import com.pvt.daoEntities.Role;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 04.05.14
 * Time: 19:37
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class RoleDaoImplementation extends CommonDaoImplementation<Role> implements IRoleDao{

    @Autowired
    public SessionFactory sessionFactory;

    public RoleDaoImplementation() {
        super(Role.class);
    }

    public List<Role> getRoleListById(Integer [] ids){
        session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Role.class);
        Criterion criterion = Restrictions.in("id", ids);
        List<Role> list = cr.add(criterion).list();
        t.commit();
        return list;

    }

    public Role getRoleById(Integer id){
        Role role;
        session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Role.class);
        Criterion criterion = Restrictions.eq("id", id);
        List result = cr.add(criterion).list();
        role = (Role) result.get(0);
        t.commit();
        return role;

    }
}
