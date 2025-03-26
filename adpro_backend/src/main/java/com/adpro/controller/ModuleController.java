package com.adpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.adpro.dto.ModuleDto;
import com.adpro.entity.Module;
import com.adpro.service.ModuleService;

@RestController
@RequestMapping("/module")
@CrossOrigin
public class ModuleController {
	@Autowired
	private ModuleService moduleService;
	
	
	@PostMapping("/")
	public ResponseEntity<Module>save(@RequestBody ModuleDto moduleDto){
		
		Module modules= new Module();
		
		modules.setName(moduleDto.getName());
		
		Module savemodule = moduleService.save(modules);
		return new ResponseEntity<>(savemodule ,HttpStatus.CREATED);
		 
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Module>> lists(){
		 List<Module> modules = moduleService.lists();
		 if (modules== null) {
			return new ResponseEntity<> (modules,HttpStatus.NOT_FOUND);
			
		}
		 return new ResponseEntity<> (modules,HttpStatus.FOUND);
		 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Module> getByid(@PathVariable("id")int id){
		Module module = moduleService.getById(id);
		 if (module== null) {
				return new ResponseEntity<> (module,HttpStatus.NOT_FOUND);
				
			}
			 return new ResponseEntity<> (module,HttpStatus.FOUND);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Module> update(@PathVariable("id")int id , @RequestBody ModuleDto moduleDto){
		Module module = moduleService.getById(id);
		 if (module== null) {
				return new ResponseEntity<> (module,HttpStatus.NOT_FOUND);
				
			}
		 module.setName(moduleDto.getName());
		 Module updatedModule = moduleService.save(module);
		 
			 return new ResponseEntity<> (updatedModule,HttpStatus.CREATED);

		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id")int id){
		Module module = moduleService.getById(id);
		 if (module== null) {
				return new ResponseEntity<> (HttpStatus.NOT_FOUND);
				
			}
			 
			 
			 
			 moduleService.deleteById(id);
			 return new ResponseEntity<> (HttpStatus.MOVED_PERMANENTLY);
		
	
	
	}
	

}
