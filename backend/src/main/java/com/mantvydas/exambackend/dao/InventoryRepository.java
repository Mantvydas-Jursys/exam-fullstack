package com.mantvydas.exambackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mantvydas.exambackend.model.InventoryEntity;


@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long>{

}
