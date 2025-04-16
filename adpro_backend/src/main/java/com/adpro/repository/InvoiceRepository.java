package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.Invoice;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
