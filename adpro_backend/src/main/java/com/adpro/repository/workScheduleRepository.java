package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.WorkSchedule;
@Repository
public interface workScheduleRepository extends JpaRepository<WorkSchedule, Integer> {

}
