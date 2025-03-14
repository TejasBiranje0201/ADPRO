package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.Module;
import com.adpro.repository.ModuleRepository;
import com.adpro.service.ModuleService;

import aj.org.objectweb.asm.commons.ModuleRemapper;
@Service
public class ModuleServiceIMPL implements ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;
	@Override
	public List<Module> lists() {
		
		return moduleRepository.findAll();
	}

	@Override
	public Module getById(int id) {
		
		return moduleRepository.findById(id).orElse(null);
	}

	@Override
	public Module save(Module module) {
		// TODO Auto-generated method stub
		return moduleRepository.save(module);
	}

	@Override
	public void deleteById(int id) {
		moduleRepository.deleteById(id);

	}

}
