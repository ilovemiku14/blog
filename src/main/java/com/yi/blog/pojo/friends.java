package com.yi.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class friends {
    private Integer id;
    private String brief_introduction;
    private String qq_img;
    private String name;

}
