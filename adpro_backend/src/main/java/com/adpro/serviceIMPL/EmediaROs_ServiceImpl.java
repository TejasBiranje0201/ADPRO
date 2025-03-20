package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.EmediaROs;
import com.adpro.repository.EmediaROs_Repository;
import com.adpro.service.EmediaROs_Service;

@Service
public class EmediaROs_ServiceImpl implements EmediaROs_Service {
	
	@Autowired
	EmediaROs_Repository emediaROs_Repository;
	
	@Override
	public List<EmediaROs> getAll() {
		
		return emediaROs_Repository.findAll();
	}

	@Override
	public EmediaROs getById(int id) {
		
		return emediaROs_Repository.findById(id).orElse(null);
	}

	@Override
	public EmediaROs save(EmediaROs emediaROs) {
		
		return emediaROs_Repository.save(emediaROs);
	}

	@Override
	public void delete(int id) {
		emediaROs_Repository.deleteById(id);

	}

}
