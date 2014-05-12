package com.pvt.daoImplementation;

import com.pvt.daoAbstract.CommonDao;
import com.pvt.daoConfiguration.HibernateUtil;
import com.pvt.daoEntities.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 18.04.14
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
public class UserDao extends CommonDao<User> {
    public UserDao() {
        super(User.class);
    }
    Logger log = Logger.getLogger(clazz);
    public List<User> getUserByCriteria(String email, String firstname, String secondname){
        if((email == null) || (firstname == null) || (secondname == null))
                return null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(User.class);
        Criterion byEmail = Restrictions.like("id", "%" + email + "%");
        Criterion byFirstname = Restrictions.like("name", "%" + firstname + "%");
        Criterion bySecondname = Restrictions.like("secondname", "%" + secondname + "%");
        cr.add(byEmail).add(byFirstname).add(bySecondname);
        try{
        list = cr.list();
        t.commit();
        }catch (HibernateException he){
             log.info("Wrong SQL query", he);
        }
        return list;
    }
}
