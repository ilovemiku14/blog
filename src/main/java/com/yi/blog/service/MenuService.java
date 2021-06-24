package com.yi.blog.service;

import com.yi.blog.pojo.Menu;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MenuService {
    List<Menu> getMenuAdminByName();
    List<Menu> getMenuWithRole();
    List<Menu> getAllMenus();
}
