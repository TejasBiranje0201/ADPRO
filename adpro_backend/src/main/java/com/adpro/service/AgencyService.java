package com.adpro.service;

import java.util.List;

import com.adpro.entity.Agency;

public interface AgencyService {

	
	List<Agency> lists();
	Agency getById(int id);
	Agency save(Agency agency);
	void deleteById(int id);
}
