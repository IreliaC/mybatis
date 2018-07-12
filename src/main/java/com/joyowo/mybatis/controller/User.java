package com.joyowo.mybatis.controller;

import lombok.Data;

/**
 * author:chenby
 * Date:2018/6/7
 */
@Data
public class User {

    private String name;

    private Integer age;

    private String hobby;

    private Integer status;


    public enum Status {
        OPEN(1), CLOSE(2);

        private Integer code;
        Status(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return this.code;
        }
    }


    public static void main(String[] args) {
        User user = new User();

        user.setStatus(Status.OPEN.getCode());

    }

}
