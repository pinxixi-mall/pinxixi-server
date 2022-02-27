package com.pinxixi.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.pinxixi.common.HttpStatusEnum;
import com.pinxixi.config.JWTConfig;
import com.pinxixi.config.PinxixiException;
import com.pinxixi.entity.TokenObj;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtils {

    /**
     * 生成token
     * @param username
     * @param password
     * @return
     */
    public static TokenObj generateToken(String username, String password) {
        try {
            //过期时间
            Date expiredDate = new Date(System.currentTimeMillis() + JWTConfig.expiration);
            //加密算法
            Algorithm algorithm = Algorithm.HMAC256(JWTConfig.secret);
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
    public static boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWTConfig.secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build();
            verifier.verify(token);
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            throw new PinxixiException(HttpStatusEnum.INVALID_AUTH.getCode(), HttpStatusEnum.INVALID_AUTH.getMsg());
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            throw new PinxixiException(HttpStatusEnum.FORBIDDEN.getCode(), HttpStatusEnum.FORBIDDEN.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new PinxixiException(HttpStatusEnum.ERROR.getCode(), "身份验证失败");
        }
        return true;
    }
}
