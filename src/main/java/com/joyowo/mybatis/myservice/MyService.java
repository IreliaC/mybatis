package com.joyowo.mybatis.myservice;

import com.joyowo.mybatis.mapper.MyMapper;
import com.joyowo.mybatis.mybatis.PageView;
import com.joyowo.mybatis.pojo.Article;
import org.apache.commons.lang3.math.NumberUtils;
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
        List<Map<String,Object>> articles = myMapper.selectAll(map);
        long count = articles.stream().filter(map2 -> NumberUtils.createInteger(
                map2.computeIfAbsent("article_id", k -> 11).toString()).equals("21")).count();
        pageView.setRecords(articles);
        return pageView;

    }


}
