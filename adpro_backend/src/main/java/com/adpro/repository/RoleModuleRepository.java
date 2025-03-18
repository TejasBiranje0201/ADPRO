package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.adpro.entity.RoleModule;

@Repository
public interface RoleModuleRepository extends JpaRepository<RoleModule, Integer>  {

}
