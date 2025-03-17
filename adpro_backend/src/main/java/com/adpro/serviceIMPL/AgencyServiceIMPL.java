package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.Agency;
import com.adpro.repository.AgencyRepository;
import com.adpro.service.AgencyService;
@Service
public class AgencyServiceIMPL implements AgencyService {
	@Autowired
	private AgencyRepository agencyRepository;

	@Override
	public List<Agency> lists() {
		// TODO Auto-generated method stub
		return agencyRepository.findAll();
	}

	@Override
	public Agency getById(int id) {
		// TODO Auto-generated method stub
		return agencyRepository.findById(id).orElse(null);
	}

	@Override
	public Agency save(Agency agency) {
		// TODO Auto-generated method stub
		return agencyRepository.save(agency);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		agencyRepository.deleteById(id);
	}

}
