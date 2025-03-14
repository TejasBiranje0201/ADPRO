package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.Role;
import com.adpro.repository.RoleRepository;
import com.adpro.service.RoleService;
@Service
public class RolesServiceIMPL implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> lists() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role getByid(int id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id).orElse(null);
	}

	@Override
	public Role save(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void deleteByid(int id) {
		roleRepository.deleteById(id);

	}

}
