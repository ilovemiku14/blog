package com.yi.blog.config.security;

import com.yi.blog.pojo.Menu;
import com.yi.blog.pojo.Role;
import com.yi.blog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * 权限控制
 * 根据请求url  分析请求需要的角色
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuService menuService;
    @Autowired
    private RedisTemplate redisTemplate;
    AntPathMatcher antPathMatcher=new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取url
        String requestUrl = ((FilterInvocation) o).getRequestUrl();

        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        List<Menu> menus = (List<Menu>) opsForValue.get("Menus_Role" );
        if (CollectionUtils.isEmpty(menus)){
            menus = menuService.getMenuWithRole();
            opsForValue.set("Menus_Role",menus);
        }
        for (Menu menu:menus) {
            //根据请求url匹配权限

            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                String[] toArray = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                return SecurityConfig.createList(toArray);
            }
        }
        //无权限给予登录后访问
        return SecurityConfig.createList("Role_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
