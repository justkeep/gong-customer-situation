package com.gong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 59448
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(value = "com.gong")
public class CustomerSituationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSituationApiApplication.class, args);
	}
}
