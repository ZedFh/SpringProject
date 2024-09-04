package com.springBootTest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.springBootTest.Beans.Client;
import com.springBootTest.Services.ClientService;




@SpringBootApplication(scanBasePackages = {"com.springBootTest","com.springBootTest.Services","com.springBootTest.Controllers"})
@ComponentScan(basePackages = {"com.springBootTest","com.springBootTest.Services","com.springBootTest.Controllers"})
public class Test {
	private static ClientService clientService; 

	@Autowired
	public Test(ClientService clientService) {
		Test.clientService = clientService;
	}
	
	public static void t() {
		clientService.addClient(new Client("zz","zz",new Date()));
	}
	
	
	public static void main(String[] args) { 
		SpringApplication.run(Test.class, args);
		t();
		
	
	}
}
