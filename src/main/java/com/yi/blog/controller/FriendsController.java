package com.yi.blog.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yi.blog.lang.ResultCode;
import com.yi.blog.mapper.friendsMapper;
import com.yi.blog.pojo.friends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/friends")
@CrossOrigin(origins = "*",maxAge = 3600)//秒单位
public class FriendsController {
    @Autowired
    private friendsMapper friendsMapper;
    @Autowired
    private ObjectMapper objectMapper;
    @ResponseBody
    @PostMapping("/selectFriend")
    public String selectFriends(){
        System.out.println("ad");
        List<friends> friends = friendsMapper.selectAll(new HashMap<>());
        try {
            return  objectMapper.writeValueAsString( ResultCode.such(200,"ok",friends));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "400";
        }

    }
}
