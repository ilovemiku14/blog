package com.yi.blog.service.impl;

import com.yi.blog.mapper.friendsMapper;
import com.yi.blog.pojo.Article;
import com.yi.blog.pojo.friends;
import com.yi.blog.service.friendsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class friendsServiceImpl implements friendsService {

    private friendsMapper friendsMapper;
    @Override
    public List<friends> selectAll(HashMap<String, String> type) {
        return friendsMapper.selectAll(type);
    }

    @Override
    public boolean detectFriends(int uid) {
        return friendsMapper.detectFriends(uid);
    }

    @Override
    public boolean updateFriends(friends friend) {
        return friendsMapper.updateFriends(friend);
    }

    @Override
    public boolean addFriends(friends friend) {
        return friendsMapper.addFriends(friend);
    }

    @Override
    public Integer selectAllCount(HashMap<String, String> type) {
        return friendsMapper.selectAllCount(type);
    }

    @Override
    public Article selectBlog(int id) {
        return friendsMapper.selectBlog(id);
    }
}
