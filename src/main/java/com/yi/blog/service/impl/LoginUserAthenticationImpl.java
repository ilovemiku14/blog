package com.yi.blog.service.impl;

import com.yi.blog.pojo.RespBean;
import com.yi.blog.pojo.user;
import com.yi.blog.util.PasswordEncryptionAES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class LoginUserAthenticationImpl implements UserDetailsService {

    private static String AES="acfun";
    @Autowired
    private PasswordEncryptionAES aes;
    @Autowired
    private LoginImpl login;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private adminServiceImpl adminService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        user name = (user) login.getUser(s);
        name.setRoles(adminService.getRoles(name.getUsername()));
        String password=encoder.encode(aes.AESDncode(AES,name.getPassword()));
        name.setPassword(password);
//    return new User(name.getUsername(),password, AuthorityUtils.commaSeparatedStringToAuthorityList(name.getJurisdiction()));
        return name;
    }
}
