package com.yi.blog.controller;

import com.yi.blog.pojo.Menu;
import com.yi.blog.pojo.MenuRole;
import com.yi.blog.pojo.RespBean;
import com.yi.blog.pojo.Role;
import com.yi.blog.service.MenuRoleService;
import com.yi.blog.service.MenuService;
import com.yi.blog.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user/Administration/Permission")
public class PermissionController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuRoleService menuRoleService;
    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRole(){
        return roleService.getListRoles();
    }
    @ApiOperation(value = "添加角色")
    @PostMapping("/")
    public RespBean addRole(@RequestBody Role role){
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        if (roleService.addRole(role)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }
    @ApiOperation(value = "删除角色")
    @PostMapping("/role/{rid}")
    public RespBean delectRole(@PathVariable Integer rid){
        if (roleService.delectRole(rid)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getMenuWithRole();
    }
    @ApiOperation(value = "查询角色名字的菜单")
    @GetMapping("/menus/{rid}")
    public List<Integer> getUserNameMenus(@PathVariable int rid){//{.stream().map(MenuRole :: getMid).collect(Collectors.toList())
//        List<Integer> byRid = menuRoleService.getMidByRid(rid);
//        byRid.stream().map(MenuRole).collect(Collectors.toList())
        return menuRoleService.getMidByRid(rid);
    }
    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids){
        Integer integer=menuRoleService.updateMenuRole(rid,mids);
        if (integer>=0){
            return RespBean.success("更新成功，现有菜单有"+integer+"条");
        }else {
            return RespBean.error("更新失败!");
        }
    }
}
