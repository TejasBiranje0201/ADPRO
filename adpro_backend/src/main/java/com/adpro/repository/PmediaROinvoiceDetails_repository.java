package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.PmediaROinvoiceDetails;

@Repository
public interface PmediaROinvoiceDetails_repository extends JpaRepository<PmediaROinvoiceDetails, Integer> {

}
