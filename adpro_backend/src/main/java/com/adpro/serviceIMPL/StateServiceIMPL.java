package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.State;
import com.adpro.repository.StateRepository;
import com.adpro.service.StateService;
@Service
public class StateServiceIMPL implements StateService {
	@Autowired
	private StateRepository stateRepository;

	@Override
	public List<State> lists() {
		
		return stateRepository.findAll();
	}

	@Override
	public State getByid(int id) {
		// TODO Auto-generated method stub
		return stateRepository.findById(id).orElse(null);
	}

}
