package com.joyowo.mybatis.controller;

import com.joyowo.mybatis.pojo.Address;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: chenby
 * Date: 2018-01-02
 */

@RestController
public class AddressController {
    @RequestMapping("/validate")
    public Address testValidate(@Valid Address address, BindingResult bindingResult) {
        return address;
    }

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();

        map.put(1,"aa");
        String s = map.computeIfAbsent(2, v -> "Aa");
    }
}
