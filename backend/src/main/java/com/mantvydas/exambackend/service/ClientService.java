package com.mantvydas.exambackend.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantvydas.exambackend.dao.ClientRepository;
import com.mantvydas.exambackend.model.ClientEntity;



@Service
public class ClientService {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientService.class);
	
	private ClientRepository clientRepository;
	
	@Autowired
	public ClientService(ClientRepository clientRepository) {
		
		this.clientRepository = clientRepository;
		
		logger.info("ClientService initialized");
	}
	
	
	
	public ClientEntity save(ClientEntity client) {
		
		if(!clientRepository.existsById(client.getId())) {
			
			
			clientRepository.save(client);
			logger.info("New ClientEntity registered to persistence");
			
			return client;
		}
		
		return null;
	}
	
	public List<ClientEntity> findAll() {
		
		return clientRepository.findAll();
	}
	
	public Optional<ClientEntity> findById(long id) {
		
		return clientRepository.findById(id);
	}
	
	public void deleteById(long id) {
		
		clientRepository.deleteById(id);
	}
	
	

}
