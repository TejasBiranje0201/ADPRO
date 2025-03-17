package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.Financialyear;
import com.adpro.repository.FinancialyearRepository;
import com.adpro.service.FinancialyearService;

@Service
public class FinancialyearServiceImpl implements FinancialyearService {
	
	@Autowired
	private FinancialyearRepository financialyearRepository;

	@Override
	public List<Financialyear> lists() {
		
		return financialyearRepository.findAll();
	}

	@Override
	public Financialyear save(Financialyear financialyear) {
		
		return financialyearRepository.save(financialyear);
	}

	@Override
	public Financialyear getById(int id) {
		
		return financialyearRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(int id) {
		financialyearRepository.deleteById(id);

	}

}
