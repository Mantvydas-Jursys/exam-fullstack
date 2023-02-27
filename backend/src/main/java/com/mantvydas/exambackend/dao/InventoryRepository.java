package com.mantvydas.exambackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mantvydas.exambackend.model.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Long>{

}
