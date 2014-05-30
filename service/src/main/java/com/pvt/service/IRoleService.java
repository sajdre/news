package com.pvt.service;

import com.pvt.daoEntities.Role;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 27.05.14
 * Time: 13:05
 * To change this template use File | Settings | File Templates.
 */
public interface IRoleService {

    public List<Role> getRoleList();

    public List<Role> getRoleListById(Integer [] ids);

    public Role getRoleById(Integer id);

}
