package com.adpro.service;

import java.util.List;

import com.adpro.entity.AdSchedules;

public interface AdSchedule_Service {
	
	public List<AdSchedules> getAll();
	
	public AdSchedules getById(int id);
	
	public AdSchedules save(AdSchedules adSchedules);
	
	public void delete(int id);
}
