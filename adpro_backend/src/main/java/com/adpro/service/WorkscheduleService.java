package com.adpro.service;

import java.util.List;

import com.adpro.entity.Workschedule;

public interface WorkscheduleService {

	List<Workschedule>lists();
	
	Workschedule getById(int id);
	
	Workschedule save(Workschedule workschedule);
	
	void deleteById(int id);
}
