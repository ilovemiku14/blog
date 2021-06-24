package com.yi.blog.mapper;


import com.yi.blog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.List;


@Component
@Mapper
public interface ArticleMapper {
    List<Article> selectAll(HashMap<String ,String> type);
    boolean detectArticle(int uid);
    boolean updateArticle(Article article);
    boolean addArticle(Article article);
    Integer selectAllCount(HashMap<String ,String> type);
    Article selectBlog(int article_uid);
}
