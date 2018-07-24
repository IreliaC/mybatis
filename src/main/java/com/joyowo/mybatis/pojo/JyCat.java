package com.joyowo.mybatis.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Author: chenby
 * Date: 2018-05-16
 */
@Data
public class JyCat {
    private Integer id;

    private Date birth;

    private Integer age;

    private String catName;

    private String hobby;

    private String company;

    private String description;
}
