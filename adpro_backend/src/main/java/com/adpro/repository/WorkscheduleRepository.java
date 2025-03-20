package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.Workschedule;

@Repository
public interface WorkscheduleRepository extends JpaRepository<Workschedule, Integer> {

}
