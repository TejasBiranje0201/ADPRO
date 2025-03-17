package com.adpro.service;

import java.util.List;

import com.adpro.entity.Invoicedetail;

public interface InvoicedetailService {

	List<Invoicedetail>lists();
	
	Invoicedetail getById(int id);
	
	Invoicedetail save(Invoicedetail invoicedetail);
	
	void deleteById(int id);
}
