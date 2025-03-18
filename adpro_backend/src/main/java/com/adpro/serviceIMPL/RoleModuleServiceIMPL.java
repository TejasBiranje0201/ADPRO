package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.RoleModule;
import com.adpro.repository.RoleModuleRepository;
import com.adpro.service.RoleModuleService;
@Service
public class RoleModuleServiceIMPL implements RoleModuleService {

	@Autowired
	private RoleModuleRepository roleModuleRepository;
	
	@Override
	public List<RoleModule> list() {
		// TODO Auto-generated method stub
		return roleModuleRepository.findAll();
	}

	@Override
	public RoleModule getById(int id) {
		// TODO Auto-generated method stub
		return roleModuleRepository.findById(id).orElse(null);
	}

	@Override
	public RoleModule save(RoleModule roleModule) {
		// TODO Auto-generated method stub
		return roleModuleRepository.save(roleModule);
	}

	@Override
	public void deletebyId(int id) {
		// TODO Auto-generated method stub
		roleModuleRepository.deleteById(id);
	}

}
