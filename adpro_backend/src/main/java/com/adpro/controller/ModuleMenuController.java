package com.adpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adpro.dto.ModuleMenusDto;
import com.adpro.entity.Menu;
import com.adpro.entity.Module;
import com.adpro.entity.Modulemenu;
import com.adpro.service.MenuService;
import com.adpro.service.ModuleMenuService;
import com.adpro.service.ModuleService;

@RestController
@RequestMapping("/modulemenu")
@CrossOrigin
public class ModuleMenuController {
	
	@Autowired
	private ModuleMenuService moduleMenuService;
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/")
	public ResponseEntity<List<Modulemenu>> list(){
		List<Modulemenu> modulemenus = moduleMenuService.list();
		if (modulemenus==null) {
			return new ResponseEntity<>(modulemenus,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(modulemenus,HttpStatus.FOUND);
	
	}
	@GetMapping("/{id}")
	public ResponseEntity<Modulemenu> getByid(@PathVariable("id")int id){
		Modulemenu modulemenu = moduleMenuService.getById(id);
		if (modulemenu==null) {
			return new ResponseEntity<>(modulemenu,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(modulemenu,HttpStatus.FOUND);
	}
	
	@PostMapping("/")
	public ResponseEntity<Modulemenu> save(@RequestBody ModuleMenusDto moduleMenusDto){
		Modulemenu modulemenu = new Modulemenu();
		 
		Module module =  moduleService.getById(moduleMenusDto.getModuleId());
		modulemenu.setModule(module);
		
		
		Menu menu = menuService.getById(moduleMenusDto.getMenuId());
		modulemenu.setMenu(menu);
		
		Modulemenu savedModulemenu = moduleMenuService.save(modulemenu);
		return new ResponseEntity<>(savedModulemenu,HttpStatus.CREATED);
		}
	
	@PutMapping("/{id}")
	public ResponseEntity<Modulemenu> updatEntity (@PathVariable("id")int id,@RequestBody ModuleMenusDto moduleMenusDto){
		Modulemenu modulemenu = moduleMenuService.getById(id);
		if (modulemenu==null) {
			return new ResponseEntity<>(modulemenu,HttpStatus.NOT_FOUND);
		}
		Module module =  moduleService.getById(moduleMenusDto.getModuleId());
		modulemenu.setModule(module);
		
		
		Menu menu = menuService.getById(moduleMenusDto.getMenuId());
		modulemenu.setMenu(menu);
		
		Modulemenu updatedModulemenu = moduleMenuService.save(modulemenu);
		return new ResponseEntity<>(updatedModulemenu,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id")int id){
		Modulemenu modulemenu = moduleMenuService.getById(id);
		if (modulemenu==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		moduleMenuService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		
	}
}
