package com.yi.blog.controller;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)//秒单位
public class CaptchaController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @ApiOperation(value = "获取验证码",produces = "image/jpeg")
    @GetMapping("/Captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response){
        //设置请求头返回类型
        response.setDateHeader("Expires",0);
        response.setHeader("Cache-control","no-store,on-cache,must-revalidate");
        response.addHeader("Cache-control","post-check=0,pre-check=0");
        response.setHeader("Pragma","no-cache");
        response.setContentType("image/jpeg");
        String text = defaultKaptcha.createText();
//        System.out.println(text+":rest");
        request.getSession().setAttribute("captcha",text);
//        System.out.println(request.getSession().getAttribute("captcha"));
        BufferedImage image = defaultKaptcha.createImage(text);
        ServletOutputStream stream;
        try {
            stream = response.getOutputStream();
            ImageIO.write(image,"jpg",stream);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }


}
