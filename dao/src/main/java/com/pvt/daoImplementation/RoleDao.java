package com.pvt.daoImplementation;

import com.pvt.daoAbstract.CommonDao;
import com.pvt.daoEntities.Role;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 04.05.14
 * Time: 19:37
 * To change this template use File | Settings | File Templates.
 */
public class RoleDao extends CommonDao<Role> {
    public RoleDao() {
        super(Role.class);
    }
}
