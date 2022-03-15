package com.dy.wind.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private static final long EXPIRE_SECONDS = 43200000;
    private static final String jwtToken = "123456!@#$%^";
    /**
     * 传入id 生成token
     * @param uuid
     * @return
     */
    public static String creatToken(String uuid) {
        LocalDateTime localDateTimeNow = LocalDateTime.now();

        Map<String, Object> claims = new HashMap<>();
        //到期时间
        LocalDateTime localDateTimeExpire = localDateTimeNow.plusSeconds(EXPIRE_SECONDS);
        Date from = Date.from(localDateTimeNow.atZone(ZoneId.systemDefault()).toInstant());
        //token过期时间
        Date expire = Date.from(localDateTimeExpire.atZone(ZoneId.systemDefault()).toInstant());
        claims.put("uuid",uuid);
        JwtBuilder builder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,jwtToken) //加密方式
                .setClaims(claims)
                .setNotBefore(from)
                .setExpiration(expire) //token过期时间 创建token时间+12小时
                .setIssuedAt(new Date(System.currentTimeMillis()));// 签发时间
        String compact = builder.compact();
        System.out.println(compact);
        return compact;
    }

    /**
     * 解析 验证 token
     * @param Token
     */
    public static Map<String, Object> checkToken(String Token) {
        try {
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(Token);
            Map<String, Object> body = (Map<String, Object>) parse.getBody();
            System.out.println(body);
            return body;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String token = creatToken("5+623");
        checkToken(token);
    }
}
