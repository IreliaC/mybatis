package com.joyowo.mybatis.controller;

import com.joyowo.mybatis.mybatis.PageView;
import com.joyowo.mybatis.myservice.MyService;
import com.joyowo.mybatis.pojo.Article;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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

    public static void main(String[] args) {
        Article a1 = new Article();
        a1.setArticleId(1);
        a1.setId(1);
        Article a2 = new Article();
        a2.setArticleId(2);
        a2.setId(2);
        Article a3 = new Article();
        a3.setArticleId(1);
        a1.setId(3);
        Article a4 = new Article();
        a4.setArticleId(2);
        a2.setId(4);

        List<Article> articles = Lists.newArrayList();
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
        articles.add(a4);
        List<Integer> collect = articles.stream().map(article -> article.getArticleId()).collect(Collectors.toList());
        Map<Integer, List<Article>> collect1 = articles.stream().collect(Collectors.groupingBy(article -> article.getArticleId()));

    }


}
