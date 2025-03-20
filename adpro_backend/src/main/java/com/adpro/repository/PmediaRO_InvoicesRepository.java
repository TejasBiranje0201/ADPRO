package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.PmediaRO_Invoices;

@Repository
public interface PmediaRO_InvoicesRepository extends JpaRepository<PmediaRO_Invoices, Integer>{

}
