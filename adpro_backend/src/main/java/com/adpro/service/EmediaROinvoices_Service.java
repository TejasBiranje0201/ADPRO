package com.adpro.service;

import java.util.List;

import com.adpro.entity.EmediaROinvoices;

public interface EmediaROinvoices_Service {
	
	public List<EmediaROinvoices> getAll();
	
	public EmediaROinvoices getbyId(int id);
	
	public EmediaROinvoices save(EmediaROinvoices emediaROinvoices);
	
	public void delete(int id);
}
