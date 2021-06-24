package com.yi.blog.service;


import com.yi.blog.pojo.Menu;
import com.yi.blog.pojo.RespBean;
import com.yi.blog.pojo.Role;
import com.yi.blog.pojo.user;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface adminService {
    /**
     * 登录后返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */

    RespBean login(String username, String password, String code, HttpServletRequest request);

    user getAdminByUserName(String username);
    /**
     *  根据用户名查询角色
     */

    List<Role> getRoles(String adminName);
}
