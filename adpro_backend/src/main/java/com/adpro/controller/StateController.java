package com.adpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adpro.entity.State;
import com.adpro.service.StateService;

@RestController
@RequestMapping("/state")
@CrossOrigin
public class StateController {
	@Autowired
	private StateService stateService;
	
	@GetMapping("/")
	public ResponseEntity<List<State>> lists(){
		List<State> state = stateService.lists();
	if (state==null) {
		return new ResponseEntity<>(state,HttpStatus.NOT_FOUND);
	}	
	return new ResponseEntity<>(state,HttpStatus.FOUND);
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<State> getbyId(@PathVariable("id")int id){
		State state = stateService.getByid(id);
		if (state==null) {
			return new ResponseEntity<>(state,HttpStatus.NOT_FOUND);
		}	
		return new ResponseEntity<>(state,HttpStatus.FOUND);
		
		}
	

}
