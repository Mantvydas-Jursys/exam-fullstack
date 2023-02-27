package com.mantvydas.exambackend.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantvydas.exambackend.dao.ClientRepository;
import com.mantvydas.exambackend.model.ClientEntity;
import com.mantvydas.exambackend.model.InventoryEntity;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<ClientEntity> getClients() {
    	
    	logger.info("clients returned");
    	
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ClientEntity getClient(@PathVariable Long id) {
    	
    	logger.info("client returned with id: " + id);
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createClient(@RequestBody ClientEntity client) throws URISyntaxException {
    	ClientEntity savedClient = clientRepository.save(client);
    	
    	logger.info("new client created with id: " + client.getId());
    	
        return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody ClientEntity client) {
    	ClientEntity currentClient = clientRepository.findById(id).orElseThrow(RuntimeException::new);
        currentClient.setName(client.getName());
        currentClient.setSurname(client.getSurname());
        currentClient.setBirthday(client.getBirthday());
        currentClient.setPhone(client.getPhone());
        currentClient.setLoyal(client.isLoyal());
        currentClient = clientRepository.save(client);

        logger.info("client updated with id: " + client.getId());
        
        return ResponseEntity.ok(currentClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
        
        logger.info("client deleted with id: " + id);
        
        return ResponseEntity.ok().build();
    }
}