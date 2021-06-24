package com.yi.blog.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "user对象",description = "")
@Accessors(chain = true)
public class user implements UserDetails {
    @ApiModelProperty(value = "uid")
    private Integer uid;
    @ApiModelProperty(value = "用户名字")
    private String username;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "用户头像")
    private String user_img;
    @ApiModelProperty(value = "用户邮箱")
    private String email;
    @ApiModelProperty(value = "用户qq")
    private String qq;
    @ApiModelProperty(value = "用户权限")
    private String jurisdiction;
    @ApiModelProperty(value = "用户角色")
    @TableField(exist = false)
    private List<Role> roles;
    public user(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public user(Integer uid, String username,String jurisdiction) {
        this.uid = uid;
        this.username = username;
        this.jurisdiction = jurisdiction;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return list;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
