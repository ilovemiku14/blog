package com.yi.blog.service;

import com.yi.blog.pojo.user;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface UserService {
    user getUser(String username);
    List<user> selectAll(HashMap<String ,String> type);
    boolean detectUser(int uid);
    boolean updateUser(HashMap<String ,String> map);
    boolean addUser(HashMap<String ,String> map);
    Integer selectAllCount(HashMap<String ,String> map);
}
