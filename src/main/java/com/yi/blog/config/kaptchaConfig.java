package com.yi.blog.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Configuration
public class kaptchaConfig {
    /**
     * 设置验证码！
     */



    @Bean
    public DefaultKaptcha defaultKaptcha(){
        DefaultKaptcha defaultKaptcha =new DefaultKaptcha();
        Properties properties  =new Properties();
        properties.setProperty("kaptcha.border","yes");
        properties.setProperty("kaptcha.border.color","105,179,90");
        properties.setProperty("kaptcha.session.key","code");
        properties.setProperty("kaptcha.textproducer.font.color","red");
        properties.setProperty("kaptcha.textproducer.font.names","宋体,微软黑体");
        properties.setProperty("kaptcha.textproducer.font.size","30");
        properties.setProperty("kaptcha.textproducer.char.length","4");
        properties.setProperty("kaptcha.textproducer.char.space","4");
        properties.setProperty("kaptcha.image.width","100");
        properties.setProperty("kaptcha.image.height","40");
        Config fig=new Config(properties);
        defaultKaptcha.setConfig(fig);
        return defaultKaptcha;

    }

}
