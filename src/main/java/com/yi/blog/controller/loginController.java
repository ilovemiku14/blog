package com.yi.blog.controller;


import com.yi.blog.pojo.AdminLoginParam;
import com.yi.blog.pojo.RespBean;
import com.yi.blog.pojo.user;
import com.yi.blog.service.adminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Api(tags = "login")
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)//秒单位
public class loginController {

    @Autowired
    private adminService adminService;

    @ApiOperation(value = "获取当前登录的信息")
    @GetMapping("/admin/info")
    public user getUserinfo(){
        user principal = (user) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (null == principal){
            return null;
        }
        String username =principal.getUsername();
        user user=adminService.getAdminByUserName(username);
        user.setPassword(null);
        user.setRoles(adminService.getRoles(user.getUsername()));
        return user;
    }

    @PostMapping("/login")
    @ApiOperation(value = "登录返回token")
    public RespBean login(@RequestBody AdminLoginParam loginParam, HttpServletRequest request){
        return adminService.login(loginParam.getUsername(),loginParam.getPassword(),loginParam.getCode(),request);
    }
    @ApiOperation(value = "退出")
    @PostMapping("/logout")
    public RespBean layout(){
        return RespBean.success("退出成功");
    }
}
