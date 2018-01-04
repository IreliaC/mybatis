package com.joyowo.mybatis.mapper;

import com.joyowo.mybatis.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Author: chenby
 * Date: 2017-12-27
 */
public interface MyMapper {

    List<Map<String,Object>> selectAll(Map<String,Object> map);
}
