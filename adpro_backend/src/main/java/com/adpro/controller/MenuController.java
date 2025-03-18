package com.adpro.controller;

import java.util.List;

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

import com.adpro.dto.MenuDto;
import com.adpro.entity.Menu;
import com.adpro.service.MenuService;

@RestController
@RequestMapping("/menu")
@CrossOrigin
public class MenuController {

	private MenuService menuservice;
	
	@PostMapping("/")
	public ResponseEntity<Menu> save(@RequestBody MenuDto menuDto){
		Menu menu = new Menu();
		menu.setTitle(menuDto.getTitle());
		menu.setLink(menuDto.getLink());
		menu.setIsparent(menuDto.isIsparent());
		menu.setParentId(menuDto.getParentId());
		menu.setSrno(menuDto.getSrno());
		
		Menu saveMenu = menuservice.save(menu);
		return new ResponseEntity<>(saveMenu,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Menu>> lists(){
		List<Menu> menus = menuservice.lists();
		if (menus==null) {
			return new ResponseEntity<>(menus,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(menus,HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Menu> getById(@PathVariable("id")int id){
		Menu menu = menuservice.getById(id);
		if (menu==null) {
			return new ResponseEntity<>(menu,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(menu,HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Menu> update(@PathVariable("id")int id, @RequestBody MenuDto menuDto){
		Menu menu = menuservice.getById(id);
		if (menu==null) {
			return new ResponseEntity<>(menu,HttpStatus.NOT_FOUND);
		}
		menu.setTitle(menuDto.getTitle());
		menu.setLink(menuDto.getLink());
		menu.setIsparent(menuDto.isIsparent());
		menu.setParentId(menuDto.getParentId());
		menu.setSrno(menuDto.getSrno());
		
		Menu saveMenu = menuservice.save(menu);
		return new ResponseEntity<>(saveMenu,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletebyId(@PathVariable("id")int id){
		Menu menu = menuservice.getById(id);
		if (menu==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		menuservice.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
}
