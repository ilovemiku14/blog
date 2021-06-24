package com.yi.blog.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dynamic {
    private Integer dynamic_id;
    private String dynamic_context;
    private String dynamic_time;
    private String dynamic_icon;
    private String dynamic_color;

}
