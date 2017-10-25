package com.yuntu.infrastructure.session.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jackdeng on 2017/10/25.
 */
@Controller
@EnableAutoConfiguration
public class HeyController {
    @RequestMapping(value = "/hey", method={RequestMethod.GET})
    @ResponseBody
    public String hey() {
        return "hey world";
    }
}
