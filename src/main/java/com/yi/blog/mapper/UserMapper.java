package com.yi.blog.mapper;


import com.yi.blog.pojo.friends;
import com.yi.blog.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface UserMapper {
   user getUser(String username);
   List<user> selectAll(HashMap<String ,String> type);
   boolean detectUser(int uid);
   boolean updateUser(HashMap<String ,String> map);
   boolean addUser(HashMap<String ,String> map);
   Integer selectAllCount(HashMap<String ,String> map);
}

