package com.yi.blog.util;


import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {
    private final static String  CLAIM_KEY_USERNAME="sub";
    private final static String  CLAIM_KEY_CREATED="created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private long expiration;

    /**
     * 根据用户信息设置token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails){
        Map<String,Object> map=new HashMap<>();
        map.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        map.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(map);
    }

    /**
     * 获取登录名
     * @param token
     * @return
     */

    public String getUSernameFromToken(String token){
        String username;
       try {
           Claims claims=getClaimsFormToken(token);
           username = claims.getSubject();
       }catch (Exception e){
           username=null;
       }
       return username;
    }

    /**
     * 获取body
     * @param token
     * @return
     */
    private Claims getClaimsFormToken(String token) {
        Claims body = null;
        try {
            body=Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
return body;
    }

    public boolean validateToken(String token,UserDetails userDetails){
        String username = getUSernameFromToken(token);

        return username.equals(userDetails.getUsername())  && ! isTokenExpired(token);
    }

    /**
     * 判断token是否失效
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token) {
        Date expireDate=getExpireDateFromToken(token);
        return expireDate.before(new Date());
    }

    /**
     * 获取失效时间
     * @param token
     * @return
     */
    private Date getExpireDateFromToken(String token) {
        Claims formToken = getClaimsFormToken(token);
        return formToken.getExpiration();
    }

    /**
     * 判断是否刷新
     * @param token
     * @return
     */

    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */

    public String refreshToken(String token){
        Claims formToken = getClaimsFormToken(token);
        formToken.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(formToken);
    }
    /**
     * 根据荷载生成jwt token
     * @param map
     * @return
     */

    private String generateToken( Map<String,Object> map){
        return Jwts.builder().setClaims(map).setExpiration(genreateExpirationDate()).signWith(SignatureAlgorithm.HS512,secret).compact();
    }

    /**
     * token失效时间
     * @return
     */
    private Date genreateExpirationDate() {
        return new Date(System.currentTimeMillis()+expiration*1000);
    }
//    public static void main(String[] args) {
//        JWTUtil a=new JWTUtil();
//        String s = a.setJwt(new user(1, "mic", "vip1"));
//        user user = a.readJwt(s);
//        System.out.println(user.getUid());
//    }
}
