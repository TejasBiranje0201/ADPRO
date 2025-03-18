package com.adpro.service;

import java.util.List;

import com.adpro.entity.RoleModule;

public interface RoleModuleService {
	List<RoleModule> list();
	RoleModule getById(int id);
	RoleModule save(RoleModule roleModule );
	void deletebyId(int id);
}
