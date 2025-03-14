package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.Module;
@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {

}
