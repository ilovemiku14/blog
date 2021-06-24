package com.yi.blog.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        //设置允许跨域的路径
//        registry.addMapping("/**")
//                //是否允许证书,不再默认开启
//                .allowCredentials(true)
//                .allowedOrigins("localhost")
//                //设置允许的方法
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                //跨域允许时间
//                .maxAge(3600);
//    }
}
