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

import com.adpro.dto.FinancialyearDto;
import com.adpro.entity.Financialyear;
import com.adpro.service.FinancialyearService;

public class FinancialyearController {
	
	@Autowired
	private FinancialyearService financialyearService;
	
	@PostMapping("/")
	public ResponseEntity<Financialyear>save(@RequestBody FinancialyearDto financialyearDto){
		
		Financialyear financialyear= new Financialyear();
		financialyear.setName(financialyearDto.getName());
		financialyear.setStartdate(financialyearDto.getStartdate());
		financialyear.setEnddate(financialyearDto.getEnddate());
		
		Financialyear updatedfinancial=financialyearService.save(financialyear);
		
		return new ResponseEntity<>(updatedfinancial,HttpStatus.CREATED);
		
	}
	@GetMapping("/")
	
	public ResponseEntity<List<Financialyear>>list(){
		
		List<Financialyear> financialyear=financialyearService.lists();
		
		if(financialyear==null) {
			return new ResponseEntity<>(financialyear,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(financialyear,HttpStatus.OK);
	}

	@GetMapping("/{id}")
	
	public ResponseEntity<Financialyear>getById(@PathVariable("id") int id){
		
		Financialyear financialyear=financialyearService.getById(id);
		
		if(financialyear==null) {
			return new ResponseEntity<>(financialyear,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(financialyear,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	
	public ResponseEntity<Void>DeleteById(@PathVariable("id")int id){
		Financialyear financialyear=financialyearService.getById(id);
		if(financialyear==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Financialyear>update(@PathVariable("id") int id,@RequestBody FinancialyearDto financialyearDto){
		
		Financialyear financialyear=financialyearService.getById(id);
		
		if(financialyear==null) {
			return new ResponseEntity<>(financialyear,HttpStatus.NOT_FOUND);
		}
		
		financialyear.setName(financialyearDto.getName());
		financialyear.setStartdate(financialyearDto.getStartdate());
		financialyear.setEnddate(financialyearDto.getEnddate());
		
		Financialyear updatedfinancial=financialyearService.save(financialyear);
		
		return new ResponseEntity<>(updatedfinancial,HttpStatus.CREATED);
	}
}
