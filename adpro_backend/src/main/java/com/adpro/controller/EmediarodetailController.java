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

import com.adpro.dto.EmediarodetailDto;
import com.adpro.entity.Emediarodetail;
import com.adpro.service.EmediarodetailService;

@RestController
@RequestMapping("/Emediarodetails")
public class EmediarodetailController {
	
	@Autowired
	private EmediarodetailService emediarodetailService;
	
	@PostMapping("/")
	public ResponseEntity<Emediarodetail>save(@RequestBody EmediarodetailDto emediarodetailDto){
		
		Emediarodetail emediarodetail =new Emediarodetail();
		
		emediarodetail.setEmediarodetailid(emediarodetailDto.getEmediarodetailid());
		emediarodetail.setSrno(emediarodetailDto.getSrno());
		emediarodetail.setFromtodate(emediarodetailDto.getFromtodate());
		emediarodetail.setNoofdays(emediarodetailDto.getNoofdays());
		emediarodetail.setFromtime(emediarodetailDto.getFromtime());
		emediarodetail.setTotime(emediarodetailDto.getTotime());
		emediarodetail.setDailyspots(emediarodetailDto.getDailyspots());
		emediarodetail.setTotalspots(emediarodetailDto.getTotalspots());
		emediarodetail.setBonuspaid(emediarodetailDto.getBonuspaid());
		emediarodetail.setCharges(emediarodetailDto.getCharges());
		emediarodetail.setDuration(emediarodetailDto.getDuration());
		emediarodetail.setTotalcharges(emediarodetailDto.getTotalcharges());
		emediarodetail.setCaption(emediarodetailDto.getCaption());
		
		Emediarodetail saveEmediarodetail= emediarodetailService.save(emediarodetail);
		
		return new ResponseEntity<>(saveEmediarodetail,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Emediarodetail>>list(){
		List<Emediarodetail> emediarodetails=emediarodetailService.lists();
		if(emediarodetails==null) {
			return new ResponseEntity<>(emediarodetails,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(emediarodetails,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Emediarodetail>getById(@PathVariable("id") int id){
		Emediarodetail emediarodetail=emediarodetailService.getById(id);
		if(emediarodetail==null) {
			return new ResponseEntity<>(emediarodetail,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(emediarodetail,HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteById(@PathVariable("id") int id){
		
		Emediarodetail emediarodetail=emediarodetailService.getById(id);
		if(emediarodetail==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Emediarodetail>update(@PathVariable("id") int id,@RequestBody EmediarodetailDto emediarodetailDto){
		Emediarodetail emediarodetail=emediarodetailService.getById(id);
		if(emediarodetail==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		
		emediarodetail.setEmediarodetailid(emediarodetailDto.getEmediarodetailid());
		emediarodetail.setSrno(emediarodetailDto.getSrno());
		emediarodetail.setFromtodate(emediarodetailDto.getFromtodate());
		emediarodetail.setNoofdays(emediarodetailDto.getNoofdays());
		emediarodetail.setFromtime(emediarodetailDto.getFromtime());
		emediarodetail.setTotime(emediarodetailDto.getTotime());
		emediarodetail.setDailyspots(emediarodetailDto.getDailyspots());
		emediarodetail.setTotalspots(emediarodetailDto.getTotalspots());
		emediarodetail.setBonuspaid(emediarodetailDto.getBonuspaid());
		emediarodetail.setCharges(emediarodetailDto.getCharges());
		emediarodetail.setDuration(emediarodetailDto.getDuration());
		emediarodetail.setTotalcharges(emediarodetailDto.getTotalcharges());
		emediarodetail.setCaption(emediarodetailDto.getCaption());
		
		Emediarodetail saveEmediarodetail= emediarodetailService.save(emediarodetail);
		
		return new ResponseEntity<>(saveEmediarodetail,HttpStatus.CREATED);
	}
}
