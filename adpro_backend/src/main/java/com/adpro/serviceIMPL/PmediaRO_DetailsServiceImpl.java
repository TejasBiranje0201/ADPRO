package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.PmediaRO_Details;
import com.adpro.repository.PmediaROdetails_Repository;
import com.adpro.service.PmediaRO_DetailsService;

@Service
public class PmediaRO_DetailsServiceImpl implements PmediaRO_DetailsService {
	
	@Autowired
	PmediaROdetails_Repository pmediaROdetails_Repository;

	@Override
	public List<PmediaRO_Details> getAll() {
		
		return pmediaROdetails_Repository.findAll();
	}

	@Override
	public PmediaRO_Details getById(int id) {
		
		return pmediaROdetails_Repository.findById(id).orElse(null);
	}

	@Override
	public PmediaRO_Details save(PmediaRO_Details pmediaRO_Details) {
		
		return pmediaROdetails_Repository.save(pmediaRO_Details);
	}

	@Override
	public void delete(int id) {
		
		pmediaROdetails_Repository.deleteById(id);

	}

}
