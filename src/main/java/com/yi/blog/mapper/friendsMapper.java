package com.yi.blog.mapper;

import com.yi.blog.pojo.Article;
import com.yi.blog.pojo.friends;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;


@Mapper
@Component
public interface friendsMapper {
    List<friends> selectAll(HashMap<String ,String> type);
    boolean detectFriends(int uid);
    boolean updateFriends(friends friend);
    boolean addFriends(friends friend);
    Integer selectAllCount(HashMap<String ,String> type);
    Article selectBlog(int id);
}
