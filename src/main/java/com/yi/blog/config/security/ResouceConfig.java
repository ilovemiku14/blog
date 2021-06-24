package com.yi.blog.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


//@Configuration
//@EnableResourceServer
public class ResouceConfig extends ResourceServerConfigurerAdapter {

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests().anyRequest().authenticated().and().requestMatchers().antMatchers("/user/**");
//        http.authorizeRequests().anyRequest().authenticated().and()
//                .requestMatchers().antMatchers("/user/**");
//    }
}
