package com.yi.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yi.blog.mapper.ArticleMapper;
import com.yi.blog.pojo.Article;
import com.yi.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    /**
     *
     * @param pageNum
     * 页数
     * @param pageSize
     * 每页5条数据
     * @return
     * 返回前端5条数据
     */
    @Override
    public List<Article> selectAll(Integer pageNum ,Integer pageSize,HashMap<String ,String> type) {
        //分页每页5条数据，在第二页
        PageHelper.startPage(pageNum,5);
        Map<String ,Object> map1=new HashMap<String ,Object>();
        List<Article> list = articleMapper.selectAll(type);
        //list数据放入下面的对象然后返回前端解析
        PageInfo<Article> pageInfo=new PageInfo<>(list);
        return pageInfo.getList();
    }
    @Override
    public boolean detectArticle(int uid) {
        return articleMapper.detectArticle(uid);
    }

    @Override
    public boolean updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public boolean addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public Integer selectAllCount(HashMap<String, String> type) {
        return articleMapper.selectAllCount(type);
    }


    @Override
    public Article selectBlog(int article_uid) {
        return articleMapper.selectBlog(article_uid);
    }
}
