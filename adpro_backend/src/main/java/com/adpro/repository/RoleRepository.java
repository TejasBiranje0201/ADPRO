package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
