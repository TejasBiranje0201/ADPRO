package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
