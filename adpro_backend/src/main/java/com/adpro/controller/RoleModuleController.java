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

import com.adpro.dto.RoleModuleDto;
import com.adpro.entity.Module;
import com.adpro.entity.RoleModule;
import com.adpro.entity.Urole;
import com.adpro.service.ModuleService;
import com.adpro.service.RoleModuleService;
import com.adpro.service.UroleService;

@RestController
@RequestMapping("/rolemodule")
@CrossOrigin
public class RoleModuleController {

	@Autowired
	private RoleModuleService roleModuleService;
	@Autowired
	private UroleService uroleService;
	@Autowired
	private ModuleService moduleService;
	@GetMapping("/")
	public ResponseEntity<List<RoleModule>> list() {
		List<RoleModule> roleModules = roleModuleService.list();
		if (roleModules==null) {
			return new ResponseEntity<> (roleModules,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<> (roleModules,HttpStatus.FOUND);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<RoleModule> getById(@PathVariable("id")int id){
		RoleModule roleModule = roleModuleService.getById(id);
		if (roleModule==null) {
			return new ResponseEntity<> (roleModule,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<> (roleModule,HttpStatus.FOUND);
		
	}
	
	@PostMapping("/")
	public ResponseEntity<RoleModule> save(@RequestBody RoleModuleDto roleModuleDto){
		RoleModule roleModule = new RoleModule();
		
		Urole urole = uroleService.getbyId(roleModuleDto.getUroleId());
		roleModule.setUrole(urole);
		
		Module module = moduleService.getById(roleModuleDto.getModuleId());
		roleModule.setModule(module);
		
		RoleModule saveModule = roleModuleService.save(roleModule);
		return new ResponseEntity<> (saveModule,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RoleModule> update(@PathVariable("id")int id,@RequestBody RoleModuleDto roleModuleDto){
		RoleModule roleModule = roleModuleService.getById(id);
		if (roleModule==null) {
			return new ResponseEntity<> (roleModule,HttpStatus.NOT_FOUND);
		}
			Urole urole = uroleService.getbyId(roleModuleDto.getUroleId());
			roleModule.setUrole(urole);
			
			Module module = moduleService.getById(roleModuleDto.getModuleId());
			roleModule.setModule(module);
			
			RoleModule updateModule = roleModuleService.save(roleModule);
			return new ResponseEntity<> (updateModule,HttpStatus.CREATED);
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id")int id){
		RoleModule roleModule = roleModuleService.getById(id);
		if (roleModule==null) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		roleModuleService.deletebyId(id);
		return new ResponseEntity<> (HttpStatus.MOVED_PERMANENTLY);
	}
	
}
