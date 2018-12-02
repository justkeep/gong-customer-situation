package com.gong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 59448
 */
@EnableAspectJAutoProxy(exposeProxy=true)
@SpringBootApplication
@ComponentScan(value = "com.gong")
@MapperScan("com.gong.customer.situation.dao.mapper")
public class CustomerSituationApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerSituationApiApplication.class, args);
	}
}
