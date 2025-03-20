package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.Pmedia_ROs;

@Repository
public interface Pmedia_ROsRepository extends JpaRepository<Pmedia_ROs, Integer> {

}
