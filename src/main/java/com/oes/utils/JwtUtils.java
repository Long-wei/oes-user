package com.oes.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class JwtUtils {


    // 密钥（需保密，建议从配置读取）
    private static final String SECRET_KEY = "7r1tXfZBkz4h9pMmJ3qR8YvL2Wx1T5bGzNk7Pm9Q3r1s";
    // 默认过期时间（单位：分钟）
    private static final long DEFAULT_EXPIRE_MINUTES = 60 * 24;

    /**
     * 生成JWT令牌（默认过期时间）
     * @param claims 自定义声明（payload）
     */
    public static String generateToken(Map<String, String> claims) {
        return generateToken(claims, DEFAULT_EXPIRE_MINUTES);
    }

    /**
     * 生成JWT令牌（自定义过期时间）
     * @param claims 自定义声明
     * @param expire 过期时间（分钟）
     */
    public static String generateToken(Map<String, String> claims, long expire) {
        // 1. 指定签名算法
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

        // 2. 计算过期时间
        long expireMillis = TimeUnit.MINUTES.toMillis(expire);
        Date expireDate = new Date(System.currentTimeMillis() + expireMillis);

        // 3. 构建令牌
        JWTCreator.Builder builder = JWT.create()
                .withIssuer("oes") // 签发者
                .withExpiresAt(expireDate);  // 过期时间

        // 4. 添加自定义声明
        claims.forEach(builder::withClaim);

        return builder.sign(algorithm);
    }

    /**
     * 解析JWT令牌
     * @return DecodedJWT 对象（可获取声明）
     * @throws JWTVerificationException 令牌无效时抛出
     */
    public static DecodedJWT parseToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("oes")
                .build(); // 校验签发者和签名
        return verifier.verify(token);
    }

    /**
     * 刷新令牌（保留原有声明，更新过期时间）
     */
    public static String refreshToken(String token, long newExpireMinutes) {
        DecodedJWT decodedJWT = parseToken(token);
        Map<String, String> claims = new HashMap<>();
        // 复制原有声明
        decodedJWT.getClaims().forEach((k, v) -> claims.put(k, v.asString()));
        return generateToken(claims, newExpireMinutes);
    }

    /**
     * 验证令牌是否有效
     */
    public static boolean isValid(String token) {
        try {
            parseToken(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}