package com.yi.blog;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yi.blog.mapper.*;
import com.yi.blog.pojo.Article;
import com.yi.blog.pojo.Dynamic;
import com.yi.blog.pojo.Timeaxis;
import com.yi.blog.pojo.user;
import com.yi.blog.service.MenuRoleService;
import com.yi.blog.service.impl.LoginImpl;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Test
    void contextLoads() {
//        System.out.println(dataSource);
//        System.out.println(userMapper.getUser("miku"));
        System.out.println();
    }
    @Test
    void aVoid(){
//        PageHelper.startPage(2,5);
//        List<Article> list = articleMapper.selectAll();
//        //list数据放入下面的对象然后返回前端解析
//        PageInfo<Article> pageInfo=new PageInfo<>(list);
//        System.out.println(list.toString());
        System.out.println(menuMapper.getMenuAdminByName("miku"));
    }

    @Test
    void ac(){
        java.util.Date utilDate = new java.util.Date();//util.Date
        System.out.println("utilDate : " + utilDate);
        //util.Date转sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("sqlDate : " + sqlDate);
    }
    @Test
    void acd(){
//        Integer integer = articleMapper.selectAllCount();
//        boolean b = articleMapper.addArticle(new Article(1, "ac", "ac", "ac", "acc", "ac", new java.util.Date()));
//        boolean b1 = articleMapper.detectArticle(44);
//        boolean b2 = articleMapper.updateArticle(new Article(45, "a", "ac", "ac", "acc", "ac","2021.4.15", "ac"));
//        System.out.println(integer);
//        System.out.println(b2);
//        List<Article> list = articleMapper.selectAll();
//        System.out.println(list.get(1).toString());
        HashMap<String,String> map=new HashMap<String,String>();
//        map.put("type","list");
//        System.out.println(articleMapper.selectAllCount(map));
        map.put("username","miac");
        map.put("password","123");
        map.put("user_img","aaa");
        map.put("email","email");
        map.put("qq","123456");
        map.put("jurisdiction","root");
        map.put("uid","5");
//        System.out.println(userMapper.addUser(map));
//        System.out.println(userMapper.detectUser(3));
//        System.out.println(userMapper.selectAll(map));
//        System.out.println(userMapper.selectAllCount(map));
        System.out.println(userMapper.updateUser(map));
    }

    @Autowired
    private DynamicMapper dynamicMapper;
    @Autowired
    private TimeaxisMapper mapper;

    @Autowired
    private friendsMapper friendMapper;
    @Autowired
    private LoginImpl login;
    @Autowired
    private MenuRoleService menuRoleService;
    @Test
    void acf( ){
//        System.out.println(login.getUser("123456"));
//        System.out.println(roleMapper.getRoles("miku"));
//        System.out.println(menuMapper.getMenuWithRole());
        Integer[] i= {10, 11, 12};
        System.out.println(menuRoleService.updateMenuRole(2,i));
    }

    @Autowired
    private RoleMapper roleMapper;


}
