package com.yi.blog.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Timeaxis {
    private Integer axis;
    private String context;
    private String time;
    private String axis_color;
    private String axis_icon;
}
