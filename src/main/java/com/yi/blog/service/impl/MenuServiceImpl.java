package com.yi.blog.service.impl;

import com.yi.blog.mapper.MenuMapper;
import com.yi.blog.pojo.Menu;
import com.yi.blog.pojo.user;
import com.yi.blog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Menu> getMenuAdminByName() {
        String name = SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication().getName();
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        List<Menu> menu = (List<Menu>) opsForValue.get("menu_" + name);
        System.out.println(menu);
        if (CollectionUtils.isEmpty(menu)){
            menu = menuMapper.getMenuAdminByName(name);
            opsForValue.set("menu_"+name,menu);
        }
        return menu;
    }

    @Override
    public List<Menu> getMenuWithRole() {
        return menuMapper.getMenuWithRole();
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
