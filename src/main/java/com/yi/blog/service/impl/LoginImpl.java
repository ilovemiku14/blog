package com.yi.blog.service.impl;

import com.yi.blog.mapper.UserMapper;
import com.yi.blog.pojo.user;
import com.yi.blog.service.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginImpl implements login {

    @Autowired
    private UserMapper userMapper;
    @Override
    public user getUser(String username) {
        return userMapper.getUser(username);
    }
}
