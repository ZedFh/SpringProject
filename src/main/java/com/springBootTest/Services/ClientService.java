package com.springBootTest.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootTest.Beans.Client;
import com.springBootTest.Repositories.ClientRepository;

import jakarta.transaction.Transactional;

@Service
public class ClientService {
	
	private final ClientRepository clientRepository;
	
	@Autowired
	public ClientService(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}
	
	public List<Client> getClients(){
		return clientRepository.findAll(); 
		
	}
	
	public void addClient(Client c) {
		 clientRepository.save(c);
	}
	
	@Transactional
	public boolean updateClient(int id, Client updatedClient) {
		Client c= findClient(id);
		
		if(c==null)
			return false;
		
		if(updatedClient.getName()!=null)
			c.setName(updatedClient.getName());

		if(updatedClient.getDdn()!=null)
			c.setDdn(updatedClient.getDdn());

		if(updatedClient.getFirstName()!=null)
			c.setFirstName(updatedClient.getFirstName());
		
		return true;
	}
	
	public void deleteClient(Client c) {
		clientRepository.delete(c);
	}
	
	public Client findClient(int id){
		Optional<Client> c = clientRepository.findById(id);
		return c.isPresent() ? c.get() : null ;
	}


}
