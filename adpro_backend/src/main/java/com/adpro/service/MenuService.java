package com.adpro.service;

import java.util.List;

import com.adpro.entity.Menu;

public interface MenuService {
	
	List<Menu> lists();
	Menu getById(int id);
	Menu save(Menu menu );
	void deleteById(int id);

}
