package com.yi.blog.config.security;


import com.yi.blog.service.impl.LoginUserAthenticationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;


//@Configuration
//@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//    @Autowired
//    private LoginUserAthenticationImpl service;
//    @Autowired
//    private AuthenticationManager manager;
//
//    private JwtTokenEnhancer jwtTokenEnhancer;
////redisToken还有种jdbcToken
//    @Autowired
//    @Qualifier("jwtTokenStore")
//    private TokenStore tokenStore;
//
////    jwt配置
////    @Autowired
////    @Qualifier("redisTokenStore")
////    private TokenStore tokenStore;
//
//    @Autowired
//    private JwtAccessTokenConverter jwtAccessTokenConverter;
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        //配置jw内容增强器
//        TokenEnhancerChain enhancerChain=new TokenEnhancerChain();
//        List<TokenEnhancer> delegates=new ArrayList<>();
//        delegates.add(jwtTokenEnhancer);
//        delegates.add(jwtAccessTokenConverter);
//        enhancerChain.setTokenEnhancers(delegates);
//        //配置token/jdbctoken/redistoken/jwttoken
//        endpoints.authenticationManager(manager).userDetailsService(service).tokenStore(tokenStore).
//                accessTokenConverter(jwtAccessTokenConverter);//jwt令牌
////        endpoints.userDetailsService(service).authenticationManager(manager).tokenStore(tokenStore);
//    }
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("admin").
//                //client密码
//                        secret(passwordEncoder.encode("7"))
//                //重定向地址
//                .redirectUris("http://www.baidu.com").
//                //授权范围
//                        scopes("all").
//                //授权模式/四种.密码，授权码，客服端，简单授权码"authorization_code"
//                        authorizedGrantTypes("password");
//    }
}
