package com.springBootTest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootTest.Beans.Client;
import com.springBootTest.Services.ClientService;

@RestController
@RequestMapping(path = "api/client")
public class ClientController {
	
	private final ClientService clientService; 
	
	@Autowired
	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@GetMapping(path = "all")
	public List<Client> getClients() {
		return clientService.getClients();
	}
	
    @PostMapping
    public String addClient(@RequestBody Client newClient) {
        clientService.addClient(newClient);
        return "Client added successfully!";
    }
    
    @PutMapping(path = "update/{id}")
    public String updateClient(@PathVariable("id") int id, @RequestBody Client updatedClient) {
        boolean success = clientService.updateClient(id, updatedClient);
        return success ? "Client updated successfully!" : "Client not found!";
    }
    
    @DeleteMapping(path = "delete/{id}")
    public String deleteClient(@PathVariable("id") int id) {
    	Client c=clientService.findClient(id);
    	
    	if(c== null)
    		return "Missing client";
    	
    	clientService.deleteClient(c);
    	return "Delete successfully";
    }
    
	@GetMapping(path = "get/{id}")
	public Client getClient(@PathVariable("id") int id) {
		return clientService.findClient(id);
	}
	
	

}
