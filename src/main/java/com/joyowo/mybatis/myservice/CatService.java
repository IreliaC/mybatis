package com.joyowo.mybatis.myservice;

import com.joyowo.mybatis.mapper.CatMapper;
import com.joyowo.mybatis.pojo.JyCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: chenby
 * Date: 2018-05-16
 */
@Service
public class CatService {
    @Autowired
    private CatMapper catMapper;

    public void insert() {
        JyCat cat = new JyCat();
        cat.setBirth(new Date());
        cat.setCatName("micky");
        cat.setCompany("this is a company");
        cat.setHobby("basketball is my hobby");
        cat.setDescription("adjakjdajdjajfsdfhsdkfsdjkfsdj mfsjdlf lsdjflsdfjfsdfghfhfghfghfghsgdhfghfghfghfhfghfghfghfhfghfghfghsygdgafsdfsdfl fjsdl dsfsfsfdnlsfjsldkfjsldkf jlskj lsdjflsjfl ");
        int insert = catMapper.insert(cat);
        if (insert == 0) {
            System.out.println("没插入成功");
        }
    }


    public void insertToomuch() {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        final Cat cat = new Cat();
//        cat.setBirth(new Date());
//        cat.setCatAge(24);
//        cat.setCatName("micky");
//        for (int i = 0; i < 6000; i++) {
//            executorService.execute(() -> {
//                catMapper.insert(cat);
//            });
//        }
    }
}
