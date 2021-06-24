package com.yi.blog.mapper;

import com.yi.blog.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MenuMapper {
     /**
      * 根据用户名（唯一）查询用户菜单
      * @param name
      * @return
      */
     List<Menu> getMenuAdminByName(String name);

     /**
      * 根据用户查询其权限
      * @return
      */
     List<Menu> getMenuWithRole();

     List<Menu> getAllMenus();
}
