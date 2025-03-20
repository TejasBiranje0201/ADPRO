package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.Pmedia_ROs;
import com.adpro.repository.Pmedia_ROsRepository;
import com.adpro.service.Pmedia_ROsService;

@Service
public class Pmedia_ROsImplementation implements Pmedia_ROsService{
	
	@Autowired
	private Pmedia_ROsRepository pmedia_ROsRepository;

	@Override
	public List<Pmedia_ROs> getAll() {
		
		return pmedia_ROsRepository.findAll();
	}

	@Override
	public Pmedia_ROs getById(int id) {
		
		return pmedia_ROsRepository.findById(id).orElse(null);
	}

	@Override
	public Pmedia_ROs save(Pmedia_ROs pmedia_ROs) {
		
		return pmedia_ROsRepository.save(pmedia_ROs);
	}

	@Override
	public void delete(int id) {
		pmedia_ROsRepository.deleteById(id);
		
	}

}
