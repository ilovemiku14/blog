package com.yi.blog.service;


import com.yi.blog.pojo.Article;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface ArticleService {
    List<Article> selectAll(Integer pageNum ,Integer pageSize,HashMap<String ,String> type);
    boolean detectArticle(int uid);
    boolean updateArticle(Article article);
    boolean addArticle(Article article);
    Integer selectAllCount(HashMap<String ,String> type);
    Article selectBlog(int article_uid);
}
