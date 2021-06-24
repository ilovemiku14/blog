package com.yi.blog.controller;


import com.yi.blog.pojo.Menu;
import com.yi.blog.service.impl.MenuServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/model/model")
@CrossOrigin(origins = "*",maxAge = 3600)//秒单位
public class MenuController {
    @Autowired
    private MenuServiceImpl menuService;
    @ApiOperation(value = "根据用户id查询菜单")
    @GetMapping("/menu")
    public List<Menu> getMenuAdminById(){
        return menuService.getMenuAdminByName();
    }
}
