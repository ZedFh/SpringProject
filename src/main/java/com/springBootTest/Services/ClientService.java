package com.springBootTest.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootTest.Beans.Client;
import com.springBootTest.Repositories.ClientRepository;

@Service
public class ClientService {
	
	private final ClientRepository clientRepository;
	
	@Autowired
	public ClientService(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}
	
	
	public List<Client> getClient(){
		return clientRepository.findAll(); 
		
	}
	
	public void addClient(Client c) {
		 clientRepository.save(c);
	}
}
