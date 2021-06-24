package com.yi.blog.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AdminLoginParam对象",description = "")
public class AdminLoginParam {

    @ApiModelProperty(value = "username",required = true)
    private String username;
    @ApiModelProperty(value = "password",required = true)
    private String password;
    @ApiModelProperty(value = "code",required = true)
    private String code;
}
