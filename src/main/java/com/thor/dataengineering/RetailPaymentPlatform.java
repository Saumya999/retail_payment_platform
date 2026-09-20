package com.thor.dataengineering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RetailPaymentPlatform {

	public static void main(String[] args) {
		SpringApplication.run(RetailPaymentPlatform.class, args);
	}

}
