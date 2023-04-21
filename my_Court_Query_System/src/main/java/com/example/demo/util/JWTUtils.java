package com.example.demo.util;

import java.util.Calendar;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtils {
//	代表了用于签名的密钥
    private static String TOKEN = "token!Q@W3e4r";

    /**
     * 生成token
     * @param map 传入payload
     * @return 返回token
     */
    public static String getToken(Map<String,String> map){
//    	创建一个JWTCreator.Builder对象
        JWTCreator.Builder builder = JWT.create();
//        将用户信息添加到JWT payload
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        Calendar instance = Calendar.getInstance();
//        设置7秒过期
        instance.add(Calendar.SECOND,7);
        builder.withExpiresAt(instance.getTime());
//        使用HMAC-SHA256算法对JWT进行签名
        return builder.sign(Algorithm.HMAC256(TOKEN)).toString();
    }


    /**
     * 验证token
     * @param token
     * @return
     */
    public static void verify(String token){
        JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }

    /**
     * 获取token中payload
     * payload是指存储在Token中的信息。它是JWT中第二个部分，由三个部分（header、payload、signature）组成，中间使用.分隔开。
	 *  在payload中，可以存储一些用户信息（例如用户ID、用户名、用户角色等），以便在服务端进行身份验证和授权。这些信息是以键值对的形式存储在payload中的，可以根据需要添加、修改或删除这些键值对。
     * @param token
     * @return
     */
    public static DecodedJWT getToken(String token){
        return JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }
}
