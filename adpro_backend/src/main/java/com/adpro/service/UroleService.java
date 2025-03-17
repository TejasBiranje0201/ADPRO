package com.adpro.service;

import java.util.List;

import com.adpro.entity.Urole;

public interface UroleService {
	
	List<Urole> lists();
	Urole getbyId(int id);
	Urole save(Urole urole);
	void deleteById(int id);

}
