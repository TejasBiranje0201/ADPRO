package com.adpro.service;

import java.util.List;

import com.adpro.entity.Pmedia_ROs;

public interface Pmedia_ROsService {

	public List<Pmedia_ROs> getAll();
	
	public Pmedia_ROs getById(int id);
	
	public Pmedia_ROs save(Pmedia_ROs pmedia_ROs);
	
	public void delete(int id);
}
