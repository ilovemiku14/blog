package com.yi.blog.util;

import com.yi.blog.pojo.user;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;

    public MeAuthenticationSuccessHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User principal = (User)authentication.getPrincipal();
        System.out.println(principal.getAuthorities());
        System.out.println(principal.getPassword());
        System.out.println(principal.getUsername());
        httpServletResponse.sendRedirect(url);

    }
}
