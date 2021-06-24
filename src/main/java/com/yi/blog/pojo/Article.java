package com.yi.blog.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Integer article_uid;
    //文章标题
    private String article_title;
    //文章摘要
    private String article_abstract;
    //文章内容
    private String article_subject;
    //文章标签
    private String article_tag;
    //文章修改者
    private String article_reviser;
    //编辑时间
    private String article_time;
    //type
    private String article_type;

}
