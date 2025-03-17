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

import com.adpro.dto.UroleDto;
import com.adpro.entity.Urole;
import com.adpro.service.UroleService;

@RestController
@RequestMapping("/urole")
@CrossOrigin
public class UroleController {

	@Autowired
	private UroleService uroleService;

	@GetMapping("/")
	public ResponseEntity<List<Urole>> lists() {
		List<Urole> uroles = uroleService.lists();
		if (uroles == null) {
			return new ResponseEntity<>(uroles, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(uroles, HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Urole> getById(@PathVariable("id") int id) {
		Urole urole = uroleService.getbyId(id);
		if (urole == null) {
			return new ResponseEntity<>(urole, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(urole, HttpStatus.FOUND);
	}

	@PostMapping("/")
	public ResponseEntity<Urole> save(@RequestBody UroleDto uroleDto) {
		Urole urole = new Urole();
		urole.setName(uroleDto.getName());

		Urole saveurole = uroleService.save(urole);

		return new ResponseEntity<>(saveurole, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Urole> update(@PathVariable("id") int id, @RequestBody UroleDto uroleDto) {
		Urole urole = uroleService.getbyId(id);
		if (urole == null) {
			return new ResponseEntity<>(urole, HttpStatus.NOT_FOUND);
		}
		urole.setName(uroleDto.getName());

		Urole updatedurole = uroleService.save(urole);

		return new ResponseEntity<>(updatedurole, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletebyId(@PathVariable("id")int id ){
		Urole urole = uroleService.getbyId(id);
		if (urole == null) {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
		uroleService.deleteById(id);
		return new ResponseEntity<>( HttpStatus.MOVED_PERMANENTLY);
		
	}

}
