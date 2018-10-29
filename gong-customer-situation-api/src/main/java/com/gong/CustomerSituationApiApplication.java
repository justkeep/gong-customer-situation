package com.gong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 59448
 */
@SpringBootApplication(scanBasePackages = {"com.gong.customer.situation.dao.mapper"})
public class CustomerSituationApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerSituationApiApplication.class, args);
	}
}
