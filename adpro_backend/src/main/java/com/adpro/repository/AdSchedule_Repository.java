package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.AdSchedules;

@Repository
public interface AdSchedule_Repository extends JpaRepository<AdSchedules, Integer>{

}
