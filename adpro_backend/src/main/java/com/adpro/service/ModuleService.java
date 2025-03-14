package com.adpro.service;

import java.util.List;

import com.adpro.entity.Module;

public interface ModuleService {
	
	List<Module> lists();
	Module getById(int id);
	Module  save(Module module);
	void deleteById(int id);

}
