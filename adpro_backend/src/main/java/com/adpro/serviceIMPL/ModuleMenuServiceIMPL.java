package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adpro.entity.Modulemenu;
import com.adpro.repository.ModuleMenuRepository;
import com.adpro.service.ModuleMenuService;

@Service
public class ModuleMenuServiceIMPL implements ModuleMenuService {

	private ModuleMenuRepository moduleMenuRepository;

	@Override
	public List<Modulemenu> list() {
		// TODO Auto-generated method stub
		return moduleMenuRepository.findAll();
	}

	@Override
	public Modulemenu getById(int id) {
		// TODO Auto-generated method stub
		return moduleMenuRepository.findById(id).orElse(null);
	}

	@Override
	public Modulemenu save(Modulemenu modulemenu) {
		// TODO Auto-generated method stub
		return moduleMenuRepository.save(modulemenu);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		moduleMenuRepository.deleteById(id);
	}

}
