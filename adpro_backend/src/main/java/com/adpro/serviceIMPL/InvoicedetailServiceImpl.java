package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.Invoicedetail;
import com.adpro.repository.InvoicedetailRepository;
import com.adpro.service.InvoicedetailService;

@Service
public class InvoicedetailServiceImpl implements InvoicedetailService {
	
	@Autowired
	private InvoicedetailRepository invoicedetailRepository;

	@Override
	public List<Invoicedetail>lists() {
		
		return invoicedetailRepository.findAll();
	}

	@Override
	public Invoicedetail getById(int id) {
		
		return invoicedetailRepository.findById(id).orElse(null);
	}

	@Override
	public Invoicedetail save(Invoicedetail invoicedetail) {
		
		return invoicedetailRepository.save(invoicedetail);
	}

	@Override
	public void deleteById(int id) {
		invoicedetailRepository.deleteById(id);
		
	}

}
