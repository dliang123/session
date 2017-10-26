package com.yuntu.infrastructure.session.controller;

import com.yuntu.infrastructure.session.common.DateUtils;
import com.yuntu.infrastructure.session.common.HttpHead;
import com.yuntu.infrastructure.session.common.Token;
import com.yuntu.infrastructure.session.core.dao.UserDao;
import com.yuntu.infrastructure.session.core.entity.UserEntity;
import com.yuntu.infrastructure.session.redis.IRedisService;
import com.yuntu.infrastructure.session.redis.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.UUID;

/**
 * user authorization center
 * Created by jackdeng on 2017/10/26.
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "auth")
public class AuthController {

    @Autowired
    private IRedisService redisService;
    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "login")
    @ResponseBody
    public Token login(String username, String password) {

        UserEntity userEntity = userDao.findByUserNameAndPassword(username, password);
        if (userEntity != null) {
            Token token = new Token();
            token.setToken(UUID.randomUUID().toString());
            token.setUserID(userEntity.getId().toString());
            return refreshToken(token);
        }
        return null;
    }

    @RequestMapping(value = "getToken")
    @ResponseBody
    public Token getToken(String token) {
        if (null == redisService.get(token)) {
            return null;
        }
        Token tokenObj = JsonUtil.toBean(redisService.get(token), Token.class);
        return refreshToken(tokenObj);
    }

    @RequestMapping(value = "refreshToken")
    @ResponseBody
    public Token refreshToken(Token token) {
        if (null == token) {
            return null;
        }
        if (null != redisService.get(token.getToken())) {
            redisService.delete(token.getToken());
        }
        redisService.set(token.getToken(), JsonUtil.toJson(token));
        redisService.expire(token.getToken(), 50);
        token.setExpiredTime(DateUtils.format(DateUtils.addSeconds(new Date(), 20), "yyyy-MM-dd HH:mm:ss"));
        return token;
    }

    @RequestMapping(value = "logout")
    @ResponseBody
    public String logout(String token) {
        redisService.delete(token);
        return "success";
    }

    @RequestMapping(value = "get/test")
    @ResponseBody
    public String test(@RequestHeader(name = HttpHead.AUTHORIZATION) String token) throws Exception {

        if (null == getToken(token)) {
            throw new Exception("请先登录");
        }
        return "test:" + getToken(token).getUserID();
    }


}
