package com.imooc.common;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonApplicationTests {
	@Autowired
	StringEncryptor stringEncryptor;
	@Test
	public void contextLoads() {
		String email = stringEncryptor.encrypt("admin");
		String pass = stringEncryptor.encrypt("root");
		System.out.println(email +"-------------------------------");
		System.out.println(pass +"-------------------------------");
	}

}

