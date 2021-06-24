package com.yi.blog.lang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * code访问的状态码200，404
 * msg错误反馈
 * data
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultCode implements Serializable {
    private Integer code;
    private String msg;
    private Object data;
    public static ResultCode such(Object data){
        ResultCode resultCode =new ResultCode();
        resultCode.setData(data);
        return resultCode;
    }
    public static ResultCode such(Integer code, String msg, Object data){
        ResultCode resultCode =new ResultCode();
        resultCode.setCode(code);
        resultCode.setMsg(msg);
        resultCode.setData(data);
        return resultCode;
    }
}
