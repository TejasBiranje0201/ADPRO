package com.adpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adpro.entity.Invoicedetail;

@Repository
public interface InvoicedetailRepository extends JpaRepository<Invoicedetail, Integer> {

}
