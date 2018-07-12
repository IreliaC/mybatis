package com.joyowo.mybatis;

import com.joyowo.mybatis.controller.RedisController;
import com.joyowo.mybatis.myservice.RedisService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

	@Autowired
	private RedisController redisController;

	@Autowired
	private RedisService redisService;

	@Test
	public void test1() {
		Object test = redisController.test();
		Assert.assertNotNull(test);
	}

	@Test
	public void test2() {
		redisService.testHash();
	}

	@Test
	public void test3() {
		redisService.testList();
	}


	@Test
	public void test4() {
		redisService.testZset();
	}
}
