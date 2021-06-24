package com.yi.blog.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.yi.blog.mapper.RoleMapper;
import com.yi.blog.mapper.UserMapper;
import com.yi.blog.pojo.Menu;
import com.yi.blog.pojo.RespBean;
import com.yi.blog.pojo.Role;
import com.yi.blog.pojo.user;
import com.yi.blog.service.adminService;
import com.yi.blog.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class adminServiceImpl implements adminService {

    @Autowired
    private UserMapper userMapper;
    @Qualifier("loginUserAthenticationImpl")
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder password;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private LoginImpl login;
    @Value("${jwt.tokenHead}")
    private String tokenhead;

    @Autowired
    private RoleMapper roleMapper;
    //验证登录信息
    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {
        String captcha = (String) request.getSession().getAttribute("captcha");
        if (StringUtils.isEmpty(code) || !captcha.equalsIgnoreCase(code)){
            return RespBean.error("验证码错误");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null==userDetails || !this.password.matches(password,userDetails.getPassword())){
            return RespBean.error("用户名不正确");
        }
        //还没改
        if (!userDetails.isEnabled()){
            return RespBean.error("账号被禁用");
        }
        //更新对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //生成token
        String token = jwtUtil.generateToken(userDetails);
        Map<String,String>  tokenMap=new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenhead);
        return RespBean.success("登录成功",tokenMap);
    }

    @Override
    public user getAdminByUserName(String username) {
        user user = login.getUser(username);
        return user;
    }

    /**
     * 根据用户id查询用户列表
     * @return
     */

//    @Override
//    public List<Menu> getMenuAdminById() {
//        System.out.println(((user)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUid());
//
//        return userMapper.getMenuAdminById(1);
//    }

    @Override
    public List<Role> getRoles(String adminName) {
        return roleMapper.getRoles(adminName);
    }
}
