package com.adpro.service;

import java.util.List;

import com.adpro.entity.Role;

public interface RoleService {

	List<Role> lists();
	Role getByid(int id);
	Role save(Role role);
	void deleteByid(int id);
}
