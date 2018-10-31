package com.gong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.gong")
@MapperScan("com.gong.customer.situation.dao.mapper")
public class CustomerSituationWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSituationWebApplication.class, args);
	}
}
