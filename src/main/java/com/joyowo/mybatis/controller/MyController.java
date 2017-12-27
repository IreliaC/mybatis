package com.joyowo.mybatis.controller;

import com.joyowo.mybatis.mybatis.PageView;
import com.joyowo.mybatis.myservice.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Author: chenby
 * Date: 2017-12-27
 */
@RestController
public class MyController {

    PageView pageView = null;
    @Autowired
    MyService myService;
    @RequestMapping("/getall")
    public PageView getAll(String pageNow,String pageSize) {
        PageView pageView = getPageView(pageNow, pageSize);
        PageView all = myService.getAll(pageView);
        return all;
    }

    public PageView getPageView(String pageNow, String pageSize) {
        if (StringUtils.isEmpty(pageNow)) {
            pageView = new PageView(1);
        } else {
            int currentPage = 1;
            try {
                currentPage = Integer.parseInt(pageNow);
            } catch (NumberFormatException e) {
            }
            pageView = new PageView(currentPage);
        }
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = "10";
        }
        int pageSizeInt = 10;
        try {
            pageSizeInt = Integer.parseInt(pageSize);
        } catch (NumberFormatException e) {
        }
        pageView.setPageSize(pageSizeInt);
        return pageView;
    }
}
