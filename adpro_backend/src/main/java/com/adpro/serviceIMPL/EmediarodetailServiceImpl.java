package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.Emediarodetail;
import com.adpro.repository.EmediarodetailRepository;
import com.adpro.service.EmediarodetailService;

@Service
public class EmediarodetailServiceImpl implements EmediarodetailService {

	@Autowired
	private EmediarodetailRepository emediarodetailRepository;
	
	@Override
	public List<Emediarodetail> lists() {
		
		return emediarodetailRepository.findAll();
	}

	@Override
	public Emediarodetail getById(int id) {
		
		return emediarodetailRepository.findById(id).orElse(null);
	}

	@Override
	public Emediarodetail save(Emediarodetail emediarodetail) {
		
		return emediarodetailRepository.save(emediarodetail);
	}

	@Override
	public void deleteById(int id) {
		
		emediarodetailRepository.deleteById(id);

	}

}
