package com.adpro.controller;

import java.util.List;

import org.hibernate.sql.ast.tree.expression.NestedColumnReference;
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

import com.adpro.dto.UserDto;
import com.adpro.entity.Agency;
import com.adpro.entity.Urole;
import com.adpro.entity.User;
import com.adpro.service.AgencyService;
import com.adpro.service.UroleService;
import com.adpro.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private AgencyService agencyService;
	@Autowired
	private UroleService uroleService;

	@GetMapping("/")
	public ResponseEntity<List<User>> list() {
		List<User> users = userService.list();
		if (users == null) {
			return new ResponseEntity<>(users, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(users, HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getByid(@PathVariable("id") int id) {
		User user = userService.getById(id);
		if (user == null) {
			return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.FOUND);
	}

	@PostMapping("/")
	public ResponseEntity<User> save(@RequestBody UserDto userDto){
		User user = new User();
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setCreatedon(userDto.getCreatedon());
		
		Agency agency = agencyService.getById(userDto.getAgencyId());
		user.setAgency(agency);
		
		Urole urole = uroleService.getbyId(userDto.getUroleid());
		user.setUrole(urole);
		
		User saveUser = userService.save(user);
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable("id") int id,@RequestBody UserDto userDto){
		User user = userService.getById(id);
		if (user == null) {
			return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
		}
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setCreatedon(userDto.getCreatedon());
		
		Agency agency = agencyService.getById(userDto.getAgencyId());
		user.setAgency(agency);
		
		Urole urole = uroleService.getbyId(userDto.getUroleid());
		user.setUrole(urole);
		
		User saveUser = userService.save(user);
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id")int id){
		User user = userService.getById(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
