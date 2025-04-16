package com.adpro.service;

import java.util.List;


import com.adpro.entity.Invoice;

public interface InvoiceService {


	List<Invoice> lists();
	
	Invoice save(Invoice invoice);
	
	Invoice getById(int id);
	
	void deleteById(int id);
}
