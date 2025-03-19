package com.adpro.service;

import java.util.List;

import com.adpro.entity.EmediaROs;

public interface EmediaROs_Service {
	
	public List<EmediaROs> getAll();
	
	public EmediaROs getById(int id);
	
	public EmediaROs save(EmediaROs emediaROs);
	
	public void delete(int id);
}
