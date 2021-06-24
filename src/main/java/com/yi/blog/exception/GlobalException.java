package com.yi.blog.exception;


import com.yi.blog.pojo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalException {

//    @ExceptionHandler(SQLException.class)
//    public RespBean mySQLException(SQLException e){
//        return RespBean.error("数据库操作异常！联系管理员");
//    }

}
