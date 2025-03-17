package com.adpro.service;

import java.util.List;

import com.adpro.entity.Financialyear;

public interface FinancialyearService {
	
	List<Financialyear>lists();
	
	Financialyear save(Financialyear financialyear);
	
	Financialyear getById(int id);
	
	void deleteById(int id);

}
