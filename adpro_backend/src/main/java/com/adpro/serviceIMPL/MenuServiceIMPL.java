package com.adpro.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adpro.entity.Menu;
import com.adpro.repository.MenuRepository;
import com.adpro.service.MenuService;
@Service
public class MenuServiceIMPL implements MenuService {
	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<Menu> lists() {
		// TODO Auto-generated method stub
		return menuRepository.findAll();
	}

	@Override
	public Menu getById(int id) {
		// TODO Auto-generated method stub
		return menuRepository.findById(id).orElse(null);
	}

	@Override
	public Menu save(Menu menu) {
		// TODO Auto-generated method stub
		return menuRepository.save(menu);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		menuRepository.deleteById(id);
	}

}
