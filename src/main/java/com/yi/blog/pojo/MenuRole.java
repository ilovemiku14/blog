package com.yi.blog.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "菜单权限表")
public class MenuRole {
    @ApiModelProperty(value = "id")
    private int id;
    @ApiModelProperty(value = "菜单id")
    private int mid;
    @ApiModelProperty(value = "角色id")
    private int rid;
}
