package com.yi.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeaderImg {
    private Integer headerImg_id;
    private String headerImg_src;
    private Date headerImg_time;
    private String username;
}
