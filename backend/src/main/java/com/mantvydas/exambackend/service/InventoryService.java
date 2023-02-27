package com.mantvydas.exambackend.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mantvydas.exambackend.dao.InventoryRepository;
import com.mantvydas.exambackend.model.InventoryEntity;

@Service
public class InventoryService {

	private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);

	private InventoryRepository inventoryRepository;

	@Autowired
	public InventoryService(InventoryRepository inventoryRepository) {

		this.inventoryRepository = inventoryRepository;

		logger.info("ClientService initialized");
	}

	public InventoryEntity save(InventoryEntity inventory) {

		if (!inventoryRepository.existsById(inventory.getId())) {

			inventoryRepository.save(inventory);
			logger.info("New InventoryEntity registered to persistence");

			return inventory;
		}

		return null;
	}

	public List<InventoryEntity> findAll() {

		return inventoryRepository.findAll();
	}

	public Optional<InventoryEntity> findById(long id) {

		return inventoryRepository.findById(id);
	}

	public void deleteById(long id) {

		logger.info("InventoryEntity deleted with id: " + id);
		inventoryRepository.deleteById(id);
	}

}
