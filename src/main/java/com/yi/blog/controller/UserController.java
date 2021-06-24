package com.yi.blog.controller;


import com.yi.blog.pojo.RespBean;
import com.yi.blog.pojo.user;
import com.yi.blog.service.UserService;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/Administration/UserMsg")
public class UserController {
    private final static String setSigningKey="acfun";
    @Autowired
    private UserService userService;
//
//    @RequestMapping("RegisterUser")
//    public String RegisterUser(Model model,@RequestBody @PathParam("user") Object user){
//
//    return "redirect:timeaxis.html";
//    }
//
//    @RequestMapping("/getToken")
//    public Object getCurrentUser(Authentication authentication, HttpServletRequest request) {
//        String header = request.getHeader("Authorization");
//        String bearer = header.substring(header.indexOf("bearer") + 7);
//        return Jwts.parser().setSigningKey(setSigningKey.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(bearer).getBody();
//    }
    @ApiOperation(value = "查询所有角色")
    @GetMapping("/selectAll")
    public List<user> selectAll(@RequestBody int sun){
        HashMap map=new HashMap();
        return userService.selectAll(map);
    }
    @ApiOperation(value = "查询指定角色")
    @GetMapping("/getUser")
    public user selectAll(@RequestParam("username") String username){
        return userService.getUser(username);
    }

    @ApiOperation(value = "更新用户信息")
    @PutMapping("/updateUser")
    public RespBean updateUser(@RequestParam("username") String username,@RequestParam("email") String email,
                               @RequestParam("qq") String qq,@RequestParam("jurisdiction") String jurisdiction ,
                               @RequestParam("uid") int uid){
        HashMap map=new HashMap();
        map.put("username",username);
        map.put("email",email);
        map.put("qq",qq);
        map.put("jurisdiction",jurisdiction);
        map.put("uid",uid);
        boolean b = userService.updateUser(map);
        if (b){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败！请查看日志");
    }
    @ApiOperation(value = "添加用户信息")
    @PostMapping("/addUser")
    public RespBean addUser(@RequestParam("username") String username,@RequestParam("email") String email,
                            @RequestParam("qq") String qq,@RequestParam("jurisdiction") String jurisdiction ,
                            @RequestParam("password") String password){
        HashMap map=new HashMap();
        map.put("username",username);
        map.put("email",email);
        map.put("qq",qq);
        map.put("jurisdiction",jurisdiction);
        map.put("password",password);
        boolean b = userService.addUser(map);
        if (b){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败！请查看日志");
    }
    @ApiOperation(value = "删除指定的用户")
    @DeleteMapping("/detectUser")
    public RespBean detectUser(@RequestBody int nun){
        if (userService.detectUser(nun)){
            return RespBean.success("删除成功");
        }
        return RespBean.success("删除失败");
    }
}
