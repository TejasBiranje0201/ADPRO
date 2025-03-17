package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.Urole;
import com.adpro.repository.UroleRepository;
import com.adpro.service.UroleService;


@Service
public class UroleServiceIMPL implements UroleService {
	
	@Autowired
	private UroleRepository uroleRepository;

	@Override
	public List<Urole> lists() {
		
		return uroleRepository.findAll();
	}

	@Override
	public Urole getbyId(int id) {
		// TODO Auto-generated method stub
		return uroleRepository.findById(id).orElse(null);
	}

	@Override
	public Urole save(Urole urole) {
		// TODO Auto-generated method stub
		return uroleRepository.save(urole);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		uroleRepository.deleteById(id);
	}

}
