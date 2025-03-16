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

import com.adpro.dto.E_mediaDto;
import com.adpro.entity.E_media;
import com.adpro.entity.State;
import com.adpro.service.E_mediaService;
import com.adpro.service.StateService;


@RestController
@RequestMapping("/emedia")
public class E_mediaController {

	@Autowired
	private E_mediaService e_mediaService;
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/")
	public ResponseEntity<List<E_media>> getAllEmedia(){
		List<E_media> e_media = e_mediaService.getAll();
		
		return new ResponseEntity<>(e_media,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<E_media> getEmediaById(@PathVariable int id){
		E_media e_media = e_mediaService.getbyId(id);
		
		return new ResponseEntity<E_media>(e_media,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<E_media> saveEmedia(@RequestBody E_mediaDto e_mediaDto){
		
		E_media e_media = new E_media();
		
		e_media.setName(e_mediaDto.getName());
		e_media.setContact(e_mediaDto.getContact());
		e_media.setAddress(e_mediaDto.getAddress());
		e_media.setGstNo(e_mediaDto.getGstNo());
		
		State state = stateService.getByid(e_mediaDto.getStateId());
		e_media.setState(state);

		E_media saveE_media = e_mediaService.save(e_media);
		
		return new ResponseEntity<E_media>(saveE_media,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<E_media> updateEmedia(@PathVariable int id, @RequestBody E_mediaDto e_mediaDto){
		
		E_media existingE_media = e_mediaService.getbyId(id);
		
		if(existingE_media == null) {
			return new ResponseEntity<>(existingE_media,HttpStatus.NOT_FOUND);
		}
		
		existingE_media.setName(e_mediaDto.getName());
		existingE_media.setContact(e_mediaDto.getContact());
		existingE_media.setAddress(e_mediaDto.getAddress());
		existingE_media.setGstNo(e_mediaDto.getGstNo());
		
		State state = stateService.getByid(e_mediaDto.getStateId());
		existingE_media.setState(state);
		
		E_media updatE_media = e_mediaService.save(existingE_media);
		
		return new ResponseEntity<E_media>(updatE_media,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmedia(@PathVariable int id){
		
		e_mediaService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
