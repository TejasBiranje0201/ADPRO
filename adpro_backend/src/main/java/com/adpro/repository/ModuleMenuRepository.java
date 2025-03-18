package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.Modulemenu;
@Repository
public interface ModuleMenuRepository extends JpaRepository<Modulemenu, Integer> {

}
