package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.EmediaROs;

@Repository
public interface EmediaROs_Repository extends JpaRepository<EmediaROs, Integer> {

}
