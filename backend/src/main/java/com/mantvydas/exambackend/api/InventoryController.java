package com.mantvydas.exambackend.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantvydas.exambackend.model.InventoryEntity;
import com.mantvydas.exambackend.service.InventoryService;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

	private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    private final InventoryService inventoryService;
    
    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    
    
    @GetMapping
    public List<InventoryEntity> getClients() {
    	
    	logger.info("clients returned");
    	
        return inventoryService.findAll();
    }

    @GetMapping("/{id}")
    public InventoryEntity getClient(@PathVariable Long id) {
    	
    	logger.info("client returned with id: " + id);
        return inventoryService.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createClient(@RequestBody InventoryEntity client) throws URISyntaxException {
    	InventoryEntity savedClient = inventoryService.save(client);
    	
    	logger.info("new client created with id: " + client.getId());
    	
        return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateInventory(@PathVariable Long id, @RequestBody InventoryEntity inventory) {
    	InventoryEntity currentInventory = inventoryService.findById(id).orElseThrow(RuntimeException::new);
        currentInventory.setName(inventory.getName());
        currentInventory.setMass(inventory.getMass());
        currentInventory.setSector(inventory.getSector());
        
        currentInventory = inventoryService.save(inventory);

        logger.info("client updated with id: " + inventory.getId());
        
        return ResponseEntity.ok(currentInventory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
    	inventoryService.deleteById(id);
        
        logger.info("client deleted with id: " + id);
        
        return ResponseEntity.ok().build();
    }
	
	
}
