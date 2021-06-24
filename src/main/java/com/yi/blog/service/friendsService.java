package com.yi.blog.service;

import com.yi.blog.pojo.Article;
import com.yi.blog.pojo.friends;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public interface friendsService {
    List<friends> selectAll(HashMap<String ,String> type);
    boolean detectFriends(int uid);
    boolean updateFriends(friends friend);
    boolean addFriends(friends friend);
    Integer selectAllCount(HashMap<String ,String> type);
    Article selectBlog(int id);
}
