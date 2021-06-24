package com.yi.blog.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yi.blog.pojo.Article;
import com.yi.blog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Api(value = "页面接口，不用管")
public class PageController {
    @RequestMapping("/toError")
    public String toError(){
        return "redirect:html/error.html";
    }

    @RequestMapping("/gologin")
    public String login(){
        return "html/login.html";
    }
    @RequestMapping("/toMain")
    public String toMain(){
        return "redirect:html/main.html";
    }
}
