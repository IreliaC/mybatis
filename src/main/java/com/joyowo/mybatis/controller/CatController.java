package com.joyowo.mybatis.controller;

import com.joyowo.mybatis.myservice.CatService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: chenby
 * Date: 2018-05-16
 */
@RestController
public class CatController {
    @Autowired
    private CatService catService;

    @RequestMapping("/insertCat")
    public void test() {
        catService.insert();
        System.out.println(11111);
    }

    @RequestMapping("/test2")
    public String test2() {
        catService.insertToomuch();
        return "ojbk";
    }

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.stream()
                //.parallel()
                .forEach(i -> System.out.println(i));
    }
}
