package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.Invoice;
import com.adpro.repository.InvoiceRepository;
import com.adpro.service.InvoiceService;
@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	
	@Override
	public List<Invoice> lists() {
		
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice save(Invoice invoice) {
	
		return invoiceRepository.save(invoice);
	}

	@Override
	public Invoice getById(int id) {
		
		return invoiceRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		invoiceRepository.deleteById(id);

	}

}
