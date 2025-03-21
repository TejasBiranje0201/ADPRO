package com.adpro.service;

import java.util.List;

import com.adpro.entity.PmediaRO_Invoices;

public interface PmediaRO_InvoicesService {

	public List<PmediaRO_Invoices> getAll();
	
	public PmediaRO_Invoices getById(int id);
	
	public PmediaRO_Invoices save(PmediaRO_Invoices pmediaRO_Invoices);
	
	public void delete(int id);
}
