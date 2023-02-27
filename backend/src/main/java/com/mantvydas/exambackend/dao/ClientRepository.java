package com.mantvydas.exambackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mantvydas.exambackend.model.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long>{

}
