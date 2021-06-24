package com.yi.blog.service;

import com.yi.blog.pojo.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<Role> getRoles(String adminName);
    List<Role> getListRoles();
    boolean delectRole(Integer rid);
    boolean updateRole(Role role);
    boolean addRole(Role role);
}
