package com.yi.blog.config.security;

import com.yi.blog.pojo.user;
import com.yi.blog.service.impl.LoginImpl;
import com.yi.blog.service.impl.adminServiceImpl;
import com.yi.blog.util.MeAccessDeniedHandler;
import com.yi.blog.util.PasswordEncryptionAES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private MeAccessDeniedHandler handler;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     * login
     *
     */
    @Autowired
    private adminServiceImpl adminService;
//    @Override
//    @Bean
//    public UserDetailsService userDetailsService(){
//        user name = (user) login.getUser(s);
//        name.setRoles(adminService.getRoles(name.getUsername()));
//        String password=encoder.encode(aes.AESDncode(AES,name.getPassword()));
//        //new User(name.getUsername(),password, AuthorityUtils.commaSeparatedStringToAuthorityList(name.getJurisdiction()))
//        return name;
//
//    }

    @Autowired
    private DataSource dataSource;
    @Autowired
    private PersistentTokenRepository tokenRepository;
    //??????????????????
    @Autowired
    private RestAuthorizationEntryPoint entryPoint;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private CustomFilter customFilter;
    @Autowired
    private CustomUrlDecisionManager customUrlDecisionManager;
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/login",
                "/logout",
                "/js/**",
                "/index.html",
                "favicon.ico",
                "/doc.html",
                "/dob.html",
                "/webjars/**",
                "/swagger-resources/**",
                "/v2/api-docs/**",
                "/swagger-ui.html/**",
                "/Captcha",
                "/model/model/menu",
                "/admin/info"
        );
    }

    /**
     * .and().authorizeRequests().antMatchers("/login","logout","/timeaxis/timeaxisList","/dynamic/dynamicList"
     *         ,"/friends/selectFriend","/Article/listBlog","/Article/blogCount","/Article/addBlog","/Article/selectBlog").permitAll()
     *                 .anyRequest().authenticated()
     * @param web
     * @throws Exception
     */
    //??????????????????
    @Override
    protected void configure(HttpSecurity web) throws Exception {
//        //???????????????????????????,??????????????????/login.html?????????????????????/loginall/???????????????????????????/main??????????????????????????????/onerror
//        web.formLogin().loginPage("/login").loginProcessingUrl("/logins").
//                //????????????
//                        successHandler(new MeAuthenticationSuccessHandler("/toMain")).
//                //????????????
//                        failureHandler(new MeAuthenticationFailureHandler("http://www.bilibili.com"));
        //???jwt?????????csrf
        web.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(customUrlDecisionManager);
                        object.setSecurityMetadataSource(customFilter);
                        return object;
                    }
                })
                .and().headers().cacheControl();
        //??????jwt?????????
        web.addFilterBefore(jwtAuthencatlonTokemFilter(), UsernamePasswordAuthenticationFilter.class);

        web.exceptionHandling().accessDeniedHandler(restfulAccessDeniedHandler).authenticationEntryPoint(entryPoint);

    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    //?????????????????????
    @Bean
    public PersistentTokenRepository tokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository=new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //??????token??????????????????
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Bean
    public JwtAuthencatlonTokemFilter jwtAuthencatlonTokemFilter(){
        return new JwtAuthencatlonTokemFilter();
    }

}
