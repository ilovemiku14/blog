package com.yi.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "菜单对象")
public class Menu {
    @ApiModelProperty(value = "菜单id")
    private int id;
    @ApiModelProperty(value = "url路径")
    private String url;
    @ApiModelProperty(value = "path路径")
    private String path;
    @ApiModelProperty(value = "组件")
    private String component;
    @ApiModelProperty(value = "名字")
    private String name;
    @ApiModelProperty(value = "组件icon")
    private String iconCls;
    @ApiModelProperty(value = "是否激活")
    private boolean keepAlive;
    @ApiModelProperty(value = "菜单id")
    private int parentld;
    @ApiModelProperty(value = "是否需要权限")
    private boolean requireAuth;
    @ApiModelProperty(value = "是否启用")
    private boolean enabled;
    @ApiModelProperty(value = "子菜单")
    @TableField(exist = false)
    private List<Menu> children;

    @ApiModelProperty(value = "角色列表")
    @TableField(exist = false)
    private List<Role> roles;

}
