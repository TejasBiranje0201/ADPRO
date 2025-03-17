package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.Urole;
@Repository
public interface UroleRepository extends JpaRepository<Urole, Integer> {

}
