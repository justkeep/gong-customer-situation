package com.gong;

import com.gong.customer.situation.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerSituationApiApplicationTests {

	@Autowired
	private LoginService loginService;

	@Test
	public void loginAspectTest() {
		//测试正常用户登录
		loginService.login("user_2");
		//测试非法用户登录
		loginService.login("user_1");
	}

}
