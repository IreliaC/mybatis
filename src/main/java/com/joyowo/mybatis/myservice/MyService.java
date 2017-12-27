package com.joyowo.mybatis.myservice;

import com.joyowo.mybatis.mapper.MyMapper;
import com.joyowo.mybatis.mybatis.PageView;
import com.joyowo.mybatis.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: chenby
 * Date: 2017-12-27
 */
@Service
public class MyService {

    @Autowired
    MyMapper myMapper;

    public PageView getAll(PageView pageView) {

        Map<String, Object> map = new HashMap<>();
        map.put("articleId",500);
        map.put("paging",pageView);
        List<Article> articles = myMapper.selectAll(map);
        pageView.setRecords(articles);
        return pageView;

    }



}
