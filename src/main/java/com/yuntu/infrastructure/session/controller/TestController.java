package com.yuntu.infrastructure.session.controller;

import com.yuntu.infrastructure.session.core.dao.MarketingActivityDao;
import com.yuntu.infrastructure.session.core.dao.UserDao;
import com.yuntu.infrastructure.session.core.entity.MarketingActivityEntity;
import com.yuntu.infrastructure.session.core.entity.UserEntity;
import com.yuntu.infrastructure.session.redis.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jackdeng on 2017/10/24.
 */
@Controller
@EnableAutoConfiguration
public class TestController {

    @Autowired
    private MarketingActivityDao activityDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private IRedisService redisService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @RequestMapping(value = "redis/test")
    @ResponseBody
    public Page<UserEntity> redisTest(String username, String password) {
//        if (null == redisService.get("market")) {
//            redisService.setList("market", userDao.findByUsername("a", new PageRequest(0, 1)).getContent());
//        }
        return userDao.findByUsername("a",  new PageRequest(0, 1));
    }


}
