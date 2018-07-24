package com.joyowo.mybatis.myservice;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author:chenby
 * Date:2018/6/12
 */
@Service
public class RedisService {

    private static final String KEY = "article_click_cnt";

    @Autowired
    private RedisTemplate redisTemplate;

    public void testHash() {
        HashOperations hashOperations = redisTemplate.opsForHash();

        hashOperations.put(KEY, "啥玩意", "222");
        List r = hashOperations.multiGet(KEY, Lists.newArrayList("article_1", "article_2"));
        Object article_1 = hashOperations.get(KEY, "article_1");
        System.out.println(article_1);
        System.out.println(r);

        Long article_11 = hashOperations.delete(KEY, "article_1");
        System.out.println(article_11);

    }


    public void testList() {
        ListOperations listOperations = redisTemplate.opsForList();
/*        Long list = listOperations.leftPush("list", 1);
        Long list1 = listOperations.leftPush("list", 2);
        Long list2 = listOperations.leftPush("list", 2);
        Long list3 = listOperations.leftPush("list", 2);
        System.out.println(list + list1 + list2 + list3);*/

//        listOperations.rightPush("list", 3);

        List list = listOperations.range("list", 0, -1);
        System.out.println(
                list
        );
    }

    private static final String Z_KEY = "nba排行榜";


    public void testZset() {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
/*        Boolean R = zSetOperations.add(Z_KEY, "Kobe", 81);
        System.out.println(R);
        Boolean jordan = zSetOperations.add(Z_KEY, "Jordan", 65);
        System.out.println(jordan);*/

/*        ZSetOperations.TypedTuple<Object> objectTypedTuple = new DefaultTypedTuple<Object>("Tracy", 61.0);

        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<Object>("James", 68.0);*/

/*        Set<ZSetOperations.TypedTuple> set = new HashSet<>();
        set.add(objectTypedTuple);
        set.add(objectTypedTuple2);*/

        //zSetOperations.add(Z_KEY, set);

        Set range = zSetOperations.reverseRange(Z_KEY, 0, -1);
        System.out.println(range);

    }
}
