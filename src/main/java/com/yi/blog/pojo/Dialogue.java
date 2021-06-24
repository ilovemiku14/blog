package com.yi.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dialogue {
    private Integer dialogue_id;
    private Integer dialogue_user;
    private Integer dialogue_pid;
    private Integer dialogue_replyid;
    private String dialogue_aid;
    private String dialogue_content;
    private Date dialogue_time;

}
