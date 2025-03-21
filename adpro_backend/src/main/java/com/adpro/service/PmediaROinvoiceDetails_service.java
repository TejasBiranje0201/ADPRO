package com.adpro.service;

import java.util.List;

import com.adpro.entity.PmediaROinvoiceDetails;

public interface PmediaROinvoiceDetails_service {
	
	public List<PmediaROinvoiceDetails> getAll();
	
	public PmediaROinvoiceDetails getById(int id);
	
	public PmediaROinvoiceDetails save(PmediaROinvoiceDetails pmediaROinvoiceDetails);
	
	public void delete(int id);
}
