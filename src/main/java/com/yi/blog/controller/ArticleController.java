package com.yi.blog.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yi.blog.lang.ResultCode;
import com.yi.blog.pojo.Article;
import com.yi.blog.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/Article")
@CrossOrigin(origins = "*",maxAge = 3600)//秒单位
public class ArticleController {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ArticleServiceImpl articleServiceImpl;

    @Autowired
    private ResultCode resultCode;

    @PostMapping("/listBlog")
    @ResponseBody
    public String listBlog(@RequestParam("index") Integer index,@RequestParam("BlogType") String blogType){
        HashMap<String ,String > map=new HashMap<>();
        if (blogType.equals("list")){

        }else {
            map.put("type",blogType);
        }
        ArrayList<Article> list = (ArrayList<Article>)articleServiceImpl.selectAll(index,5,map);
        String s=null;
        try {
            ResultCode resultCode = this.resultCode.such(200,"ok",list);
            s = objectMapper.writeValueAsString(resultCode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }

    @ResponseBody
    @PostMapping("/blogCount")
    public Integer blogCount(@RequestParam("CountType") String type){
        HashMap<String ,String > map=new HashMap<>();
        if (type.equals("list")){
            return articleServiceImpl.selectAllCount(map);
        }else {
            map.put("type",type);
            return articleServiceImpl.selectAllCount(map);
        }

    }

    @ResponseBody
    @PostMapping("/addBlog")
    public String addBlog(@RequestParam("article_title") String article_title,@RequestParam("article_abstract") String article_abstract,
                          @RequestParam("article_subject") String article_subject,@RequestParam("article_tag") String article_tag,
                          @RequestParam("article_reviser") String article_reviser,@RequestParam("article_time") String article_time,
                          @RequestParam("article_type") String article_type){

          try {
              boolean b = articleServiceImpl.addArticle(new Article(1, article_title,
                      article_abstract, article_subject, article_tag, article_reviser, article_time, article_type));
              return "200";
          }catch (Exception e){
              return "400";
          }
    }
    @ResponseBody
    @PostMapping("/selectBlog")
    public String selectBlog(@RequestParam("id") String id){
        String s=null;
        try {
           s = objectMapper.writeValueAsString(this.resultCode.such(200,"ok",articleServiceImpl.selectBlog(Integer.parseInt(id))));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }
}
