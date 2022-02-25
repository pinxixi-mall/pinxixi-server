package com.pinxixi.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.pinxixi.entity.TokenObj;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    //过期时间: 30分钟
    private static final long EXPIRED_TIME = 30 * 60 * 1000;

    //秘钥
    private static final String TOKEN_SECRET = "pinxixi2022666";

    /**
     * 生成token
     * @param username
     * @param password
     * @return
     */
    public static TokenObj generateToken(String username, String password) {
        try {
            //过期时间
            Date expiredDate = new Date(System.currentTimeMillis() + EXPIRED_TIME);
            //加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //生成
            String token = JWT.create()
                    .withHeader(header)
                    .withIssuer("auth0")
                    .withClaim("username", username)
                    .withClaim("password", password)
                    .withExpiresAt(expiredDate)
                    .sign(algorithm);
            TokenObj tokenObj = new TokenObj();
            tokenObj.setToken(token);
            tokenObj.setUpdateTime(new Date());
            tokenObj.setExpiredDate(expiredDate);
            return tokenObj;
        } catch (JWTCreationException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static void verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println(jwt);
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }
    }
}
