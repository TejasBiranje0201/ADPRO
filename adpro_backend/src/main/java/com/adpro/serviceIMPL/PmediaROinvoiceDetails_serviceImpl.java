package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.PmediaROinvoiceDetails;
import com.adpro.repository.PmediaROinvoiceDetails_repository;
import com.adpro.service.PmediaROinvoiceDetails_service;

@Service
public class PmediaROinvoiceDetails_serviceImpl implements PmediaROinvoiceDetails_service{

	@Autowired
	PmediaROinvoiceDetails_repository pmediaROinvoiceDetails_repository;
	
	@Override
	public List<PmediaROinvoiceDetails> getAll() {
		
		return pmediaROinvoiceDetails_repository.findAll();
	}

	@Override
	public PmediaROinvoiceDetails getById(int id) {
		
		return pmediaROinvoiceDetails_repository.findById(id).orElse(null);
	}

	@Override
	public PmediaROinvoiceDetails save(PmediaROinvoiceDetails pmediaROinvoiceDetails) {
		
		return pmediaROinvoiceDetails_repository.save(pmediaROinvoiceDetails);
	}

	@Override
	public void delete(int id) {
		pmediaROinvoiceDetails_repository.deleteById(id);
		
	}

}
