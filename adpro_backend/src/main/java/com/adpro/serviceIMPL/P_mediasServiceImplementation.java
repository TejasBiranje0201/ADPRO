package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.P_medias;
import com.adpro.repository.P_mediasRepository;
import com.adpro.service.P_mediasService;

@Service
public class P_mediasServiceImplementation implements P_mediasService {
	
	@Autowired
	private P_mediasRepository p_mediasRepository;

	@Override
	public List<P_medias> getAll() {
	
		return p_mediasRepository.findAll();
	}

	@Override
	public P_medias getById(int id) {
		
		return p_mediasRepository.findById(id).orElse(null);
	}

	@Override
	public P_medias save(P_medias p_medias) {
		
		return p_mediasRepository.save(p_medias);
	}

	@Override
	public void delete(int id) {
		p_mediasRepository.deleteById(id);
		
	}

}
