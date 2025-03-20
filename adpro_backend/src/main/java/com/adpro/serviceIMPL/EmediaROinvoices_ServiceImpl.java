package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.EmediaROinvoices;
import com.adpro.repository.EmediaROinvoices_Repository;
import com.adpro.service.EmediaROinvoices_Service;

@Service
public class EmediaROinvoices_ServiceImpl implements EmediaROinvoices_Service {
	
	@Autowired
	 private EmediaROinvoices_Repository emediaROinvoices_Repository;

	@Override
	public List<EmediaROinvoices> getAll() {
		
		return emediaROinvoices_Repository.findAll();
	}

	@Override
	public EmediaROinvoices getbyId(int id) {
		
		return emediaROinvoices_Repository.findById(id).orElse(null);
	}

	@Override
	public EmediaROinvoices save(EmediaROinvoices emediaROinvoices) {
		
		return emediaROinvoices_Repository.save(emediaROinvoices);
	}

	@Override
	public void delete(int id) {
		emediaROinvoices_Repository.deleteById(id);

	}

}
