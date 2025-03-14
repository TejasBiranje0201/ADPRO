package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.State;
@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
