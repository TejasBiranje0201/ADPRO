package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.PmediaRO_Invoices;
import com.adpro.repository.PmediaRO_InvoicesRepository;
import com.adpro.service.PmediaRO_InvoicesService;

@Service
public class PmediaRO_InvoicesServiceImpl implements PmediaRO_InvoicesService{

	@Autowired
	PmediaRO_InvoicesRepository pmediaRO_InvoicesRepository;
	
	@Override
	public List<PmediaRO_Invoices> getAll() {
		
		return pmediaRO_InvoicesRepository.findAll();
	}

	@Override
	public PmediaRO_Invoices getById(int id) {
		
		return pmediaRO_InvoicesRepository.findById(id).orElse(null);
	}

	@Override
	public PmediaRO_Invoices save(PmediaRO_Invoices pmediaRO_Invoices) {
		
		return pmediaRO_InvoicesRepository.save(pmediaRO_Invoices);
	}

	@Override
	public void delete(int id) {
		
		pmediaRO_InvoicesRepository.deleteById(id);
		
	}
	
	
}
