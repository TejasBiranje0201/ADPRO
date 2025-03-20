package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.EmediaROinvoices;

@Repository
public interface EmediaROinvoices_Repository extends JpaRepository<EmediaROinvoices, Integer> {
	
}
