package com.yi.blog.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "权限角色")
public class Role {
    @ApiModelProperty(value = "id")
    private int id;
    @ApiModelProperty(value = "名字")
    private String name;
    @ApiModelProperty(value = "用户权限")
    private String nameZh;
}
