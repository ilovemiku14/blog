package com.yi.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @GetMapping("/user/Administration/holle")
    public String h1(){
            return "/user/Administration/**";
        }
    @GetMapping("/blog/friends/h1")
    public String h2(){
        return "/user/Administration/h1";
    }
    @GetMapping("/blog/blogmsg/h1")
    public String h3(){
        return "/user/Administration/h1";
    }
}
