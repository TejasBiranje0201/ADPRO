package com.adpro.service;

import java.util.List;

import com.adpro.entity.Holiday;

public interface HolidayService {
	
	List<Holiday> lists();
	
	Holiday save(Holiday holiday);
	
	Holiday getById(int id);
	
	void deleteById(int id);

}
