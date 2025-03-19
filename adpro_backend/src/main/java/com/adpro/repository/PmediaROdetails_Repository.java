package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.PmediaRO_Details;

@Repository
public interface PmediaROdetails_Repository extends JpaRepository<PmediaRO_Details, Integer> {

}
