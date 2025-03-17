package com.adpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adpro.dto.P_mediasDto;
import com.adpro.entity.P_medias;
import com.adpro.entity.State;
import com.adpro.service.P_mediasService;
import com.adpro.service.StateService;


@RestController
@RequestMapping("/pmedia")
public class P_mediasController {
	
	@Autowired
	private P_mediasService p_mediasService;
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/")
	public ResponseEntity<List<P_medias>> getAllPmedias(){
		
		List<P_medias> p_medias = p_mediasService.getAll();
		
		return new ResponseEntity<>(p_medias,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<P_medias> getPmediasById(@PathVariable int id){
		
		P_medias p_medias = p_mediasService.getById(id);
		
		return new ResponseEntity<>(p_medias,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<P_medias> savePmedias(@RequestBody P_mediasDto p_mediasDto){
		
		P_medias p_medias = new P_medias();
		
		p_medias.setName(p_mediasDto.getName());
		p_medias.setContact(p_mediasDto.getContact());
		p_medias.setAddress(p_mediasDto.getAddress());
		p_medias.setGstNo(p_mediasDto.getGstNo());
		
		State state = stateService.getByid(p_mediasDto.getStateId());
		p_medias.setState(state);
		
		P_medias savePmedias = p_mediasService.save(p_medias);
		
		return new ResponseEntity<P_medias>(savePmedias,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<P_medias> updatePmedias(@PathVariable int id, @RequestBody P_mediasDto p_mediasDto){
		
		P_medias existingP_medias = p_mediasService.getById(id);
		
		if(existingP_medias == null) {
			return new ResponseEntity<>(existingP_medias,HttpStatus.NOT_FOUND);
		}
		
		existingP_medias.setName(p_mediasDto.getName());
		existingP_medias.setContact(p_mediasDto.getContact());
		existingP_medias.setAddress(p_mediasDto.getAddress());
		existingP_medias.setGstNo(p_mediasDto.getGstNo());
		
		State state = stateService.getByid(p_mediasDto.getStateId());
		existingP_medias.setState(state);
		
		P_medias updateP_medias = p_mediasService.save(existingP_medias);
		return new ResponseEntity<P_medias>(updateP_medias,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePmedias(@PathVariable int id){
		p_mediasService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
} 
