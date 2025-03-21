package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.AdSchedules;
import com.adpro.repository.AdSchedule_Repository;
import com.adpro.service.AdSchedule_Service;

@Service
public class AdSchedule_ServiceImpl implements AdSchedule_Service {
	
	@Autowired
	private AdSchedule_Repository adSchedule_Repository;

	@Override
	public List<AdSchedules> getAll() {
		
		return adSchedule_Repository.findAll();
	}

	@Override
	public AdSchedules getById(int id) {
		
		return adSchedule_Repository.findById(id).orElse(null);
	}

	@Override
	public AdSchedules save(AdSchedules adSchedules) {
		
		return adSchedule_Repository.save(adSchedules);
	}

	@Override
	public void delete(int id) {
		adSchedule_Repository.deleteById(id);

	}

}
