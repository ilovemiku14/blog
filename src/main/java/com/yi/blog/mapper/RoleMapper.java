package com.yi.blog.mapper;

import com.yi.blog.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RoleMapper {
    List<Role> getRoles(String adminName);
    List<Role> getListRoles();
    boolean delectRole(Integer rid);
    boolean updateRole(Role role);
    boolean addRole(Role role);
}
