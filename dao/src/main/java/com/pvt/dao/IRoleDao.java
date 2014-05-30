package com.pvt.dao;

import com.pvt.daoEntities.Role;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 27.05.14
 * Time: 11:35
 * To change this template use File | Settings | File Templates.
 */
public interface IRoleDao extends ICommonDao<Role> {

    public List<Role> getRoleListById(Integer [] ids);

    public Role getRoleById(Integer id);
}
