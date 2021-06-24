package com.yi.blog.service.impl;

import com.yi.blog.mapper.RoleMapper;
import com.yi.blog.pojo.Role;
import com.yi.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> getRoles(String adminName) {
        return roleMapper.getRoles(adminName);
    }

    @Override
    public List<Role> getListRoles() {
        return roleMapper.getListRoles();
    }

    @Override
    public boolean delectRole(Integer rid) {
        return roleMapper.delectRole(rid);
    }

    @Override
    public boolean updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public boolean addRole(Role role) {
        return roleMapper.addRole(role);
    }
}
