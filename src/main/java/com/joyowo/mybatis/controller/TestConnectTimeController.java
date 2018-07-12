package com.joyowo.mybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: chenby
 * Date: 2018-02-07
 */
@RestController
public class TestConnectTimeController {

    @RequestMapping("/test")
    public String testTime() throws Exception {
        Thread.sleep(10000L);
        return "timeOut";
    }
}
