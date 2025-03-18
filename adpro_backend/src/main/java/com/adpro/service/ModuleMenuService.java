package com.adpro.service;

import java.util.List;

import com.adpro.entity.Modulemenu;

public interface ModuleMenuService {

	List<Modulemenu> list();
	Modulemenu getById(int id);
	Modulemenu save(Modulemenu modulemenu);
	void deleteById(int id);
}
