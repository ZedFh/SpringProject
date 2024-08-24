package com.springBootTest.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/clients")
public class ClientController {
	
	@GetMapping(path = "all")
	public String getClients() {
		return "Hello World";
	}

}
