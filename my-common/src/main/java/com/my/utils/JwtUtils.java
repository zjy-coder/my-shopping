package com.my.utils;

import com.my.entity.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @Date 2020-07-15 11:47
 * @Created by zjy
 */
public class JwtUtils {

    public static final String SUBJECT = "my-shopping";

    /**
     * 过期时间，毫秒，一周
     */
    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;

    /**
     * 秘钥
     */
    public static final String APPSECRET = "d61c5a96bbefd18dec50581ae4117707";

    /**
     * 生成jwt
     * @param userInfo
     * @return
     */
    public static String geneJsonWebToken(UserInfo userInfo) {
        if (userInfo == null || StringUtils.isEmpty(userInfo.getUserId()) || StringUtils.isEmpty(userInfo.getUserName())) {
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("userId", userInfo.getUserId())
                .claim("name", userInfo.getUserName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();
        return token;
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {

        try {
            final Claims claims = Jwts.parser().setSigningKey(APPSECRET).
                    parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
//        UserInfo user = new UserInfo();
//        user.setUserId("admin");
//        user.setUserName("管理员");

//        String token = JwtUtils.geneJsonWebToken(user);
//        System.out.println(token);


        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInVzZXJJZCI6ImFkbWluIiwibmFtZSI6IueuoeeQhuWRmCIsImlhdCI6MTU5NDc5NDk1MCwiZXhwIjoxNTk1Mzk5NzUwfQ.8Ni3UyrQWjr2YsrZGJFm99G0JbK2uPRiOBuUH8SwXcg";
        Claims claims = JwtUtils.checkJWT(token);
        if (claims != null) {
            String id = (String) claims.get("userId");
            String name = (String) claims.get("name");
            System.out.println(id);
            System.out.println(name);
        } else {
            System.out.println("非法token");
        }
    }
    //


}
