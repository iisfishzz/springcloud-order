package com.imooc.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonApplication {
	public static void main(String[] args) {
		System.setProperty("jasypt.encryptor.password","APPOINT_PASSWORD#$176");
		SpringApplication.run(CommonApplication.class, args);
	}

}

