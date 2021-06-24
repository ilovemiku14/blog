package com.yi.blog.service;

import com.yi.blog.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;


@Mapper
@Service
public interface login {
    user getUser(String username);

}
