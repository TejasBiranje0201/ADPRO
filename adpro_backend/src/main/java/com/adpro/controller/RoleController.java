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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adpro.dto.RoleDto;
import com.adpro.entity.Role;
import com.adpro.service.RoleService;

@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController {

	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/")
	public ResponseEntity<Role>save(@RequestBody RoleDto roleDto){
		
		Role role = new Role();
		
		role.setName(roleDto.getName());
		
		Role savedRole= roleService.save(role);
		
		return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Role>> lists(){
		List<Role> role = roleService.lists();
		if(role==null) {
			return	new ResponseEntity<>(role, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(role,HttpStatus.FOUND);
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Role> getById(@PathVariable("id")int id ){
		Role  role = roleService.getByid(id);
		if(role==null) {
			 return new ResponseEntity<>(role, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(role,HttpStatus.FOUND);
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id")int id){
		Role role = roleService.getByid(id);
		if(role==null) {
			 return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
		
		roleService.deleteByid(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
