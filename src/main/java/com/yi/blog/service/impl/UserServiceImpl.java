package com.yi.blog.service.impl;

import com.yi.blog.mapper.UserMapper;
import com.yi.blog.pojo.user;
import com.yi.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public user getUser(String username) {
        return userMapper.getUser(username);
    }

    @Override
    public List<user> selectAll(HashMap<String, String> type) {
        return userMapper.selectAll(type);
    }

    @Override
    public boolean detectUser(int uid) {
        return userMapper.detectUser(uid);
    }

    @Override
    public boolean updateUser(HashMap<String ,String> map) {
        return userMapper.updateUser(map);
    }

    @Override
    public boolean addUser(HashMap<String ,String> map) {
        return userMapper.addUser(map);
    }

    @Override
    public Integer selectAllCount(HashMap<String, String> map) {
        return userMapper.selectAllCount(map);
    }
}
