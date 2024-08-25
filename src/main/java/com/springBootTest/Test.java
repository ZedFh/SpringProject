package com.springBootTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication(scanBasePackages = {"com.springBootTest","com.springBootTest.Services","com.springBootTest.Controllers"})
@ComponentScan(basePackages = {"com.springBootTest","com.springBootTest.Services","com.springBootTest.Controllers"})
public class Test {

	public static void main(String[] args) { 
		SpringApplication.run(Test.class, args);
	}
}
