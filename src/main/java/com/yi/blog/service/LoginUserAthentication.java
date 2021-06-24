package com.yi.blog.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface LoginUserAthentication {
    UserDetails ByUSerName(String username);
}
